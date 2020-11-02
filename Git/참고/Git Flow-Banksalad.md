# 뱅크샐러드의 Git Flow Strategy

### Git-Flow

기존에 사용하던 Git 브랜칭 모델은 [Git-Flow](https://nvie.com/posts/a-successful-git-branching-model/)였습니다. Git-Flow는 오픈소스 프로젝트와 같이 다수의 메인테이너들이 하나의 repository에서 동시에 작업할 수 있는 상황에서 큰 장점이 있는 브랜칭 모델입니다. 총 5가지의 종류의 브랜치가 존재하며 대략적인 다이어그램은 아래와 같습니다.

[![Git-Flow branch diagram](https://blog.banksalad.com/static/5c4381fd1ef754f61012604281e848f2/b9e4f/gitflow.png)](https://blog.banksalad.com/static/5c4381fd1ef754f61012604281e848f2/11796/gitflow.png)



**Figure 1 | Git-Flow branch diagram**



Git-Flow를 사용하여 배포하는 시나리오는 다음과 같습니다.

1. 먼저 develop branch를 base로 feature branch를 생성하고, 해당 branch에서 관련 작업을 진행합니다.
2. 작업 완료 후 이를 develop branch에 merge 합니다.
3. 그다음 또다시 develop branch를 base로 하여 release branch를 생성하고 이 branch에서 배포에 필요한 문서 작업 혹은 버그 수정 등을 합니다.
4. release 준비가 완료된 뒤에 해당 branch를 각각 master와 develop branch에 merge 합니다.

위 과정에서 merge 시에는 모두 Pull Request를 통해서 code review를 받고 진행했습니다. 모든 Pull Request에 대해서 Lint, Test 등의 Continuous Integration 과정을 [travis CI](https://travis-ci.org/)를 사용해서 진행했습니다.

### Tag Based Deployment

최종적으로 배포할 변경 사항이 담긴 commit이 master branch에 merge 되었을 때, 해당 commit에 git tag를 생성하여 push 합니다. tag의 versioning 방식으로는 [Semantic Versioning](https://semver.org/) 을 사용했습니다. Repository에 tag가 push 되었을 때 해당 tag와 같은 tag를 사용해서 docker image를 build 한 뒤 docker hub에 push 합니다. 이 CD pipeline 또한 마찬가지로 travis CI 위에서 진행했습니다.

### ChatOps

travis CI에서 docker image를 docker hub에 push 한 뒤 기존에 존재했던 배포 관리 서비스에 HTTP를 통해 배포 요청을 보냈습니다. 이 요청에는 배포할 서비스 이름, 배포 환경 그리고 image tag가 포함되어 있습니다. 기존 배포 관리 서비스는 요청을 받으면 배포 전용 슬랙 채널에 배포 준비가 되었음을 알립니다. 이를 개발자가 확인하여 직접 진행 버튼을 누르면 실제 배포가 수행되었습니다. 배포 관리 서비스는 수행 요청을 받아 kubernetes Deployment object의 image tag를 수정하여 새로운 Deployment를 띄우게 됩니다. 최종적으로 kubernetes에 의해 Rolling Update가 진행되고 새로운 버전의 서비스가 배포됩니다.

------

## Pain Points

기존의 배포 프로세스를 유지한 채로 하루에 1,000번 이상의 배포를 하는 조직으로 나아가기 위해서는 너무나 많은 고통이 존재했습니다.

먼저 Git-Flow를 활용한다면 하나의 기능을 배포하는 데 있어서 무려 5번의 branch switching이 필요하고, 6번의 Pull Request와 이에 따른 6번의 Code Review가 필요했습니다. 이 말은 다르게 말하면 코드 오너가 6번이나 코드를 리뷰하고 승인을 해줘야 한다는 것이죠. 이렇게 복잡한 프로세스는 자연스럽게 배포를 귀찮은 존재로 만듭니다. 이로 인해 간단한 수정 사항의 경우 develop branch에 merge 한 뒤 배포하지 않는 일이 종종 발생하기 시작했습니다. 이런 배포되지 않은 변경 사항이 쌓이면서 나중에 필요할 때 한 번에 너무 많은 변경사항을 포함한, 부담스러운 배포를 진행해야만 했습니다. 배포 시 변경 사항이 많을수록 장애가 발생할 수 있는 확률은 당연히 증가하기 때문에 개발자에게는 배포는 무서운 존재가 되었습니다.

또한 Tag Based Deployment는 하루에도 수많은 사용자 경험을 개선하기 위해 수많은 커밋을 배포해야 하는 MSA 기반 조직과는 맞지 않았습니다. 예를 들어 하나의 서비스를 10명의 개발자가 각각 10개의 새로운 기능을 동시에 구현하고 있었고, 이에 대한 PR들이 동시에 merge 되어 배포된 상황을 가정합시다. 특정 기능 하나가 장애를 발생시킬 때 어떻게 이를 롤백해 볼 수 있을까요? tag 기반으로는 전체 기능을 롤백할 수밖에 없습니다. 그렇지 않으려면 기능마다 하나의 버전을 만들어야만 하는데 그 역시 너무 수고로운 작업이 됩니다. 또한 semantic versioning은 오픈소스처럼 버전 간 호환성이 의미 있는 프로젝트와 어울리지만, 우리처럼 PR의 크기를 작게 가져가고 빈번하게 배포가 일어나는 상황에선 어울리지 않았습니다. 갈수록 그 크기는 커지되 더 기민해져 가는 조직엔 그에 맞는 배포 정책이 필요했습니다.

마지막으로 ChatOps를 사용힌 배포는 편리했으나, 몇 가지 한계점이 존재했습니다. 먼저 서비스를 새로 배포하기 위해선 기존 배포 서비스의 소스 코드를 직접 수정했어야 했습니다. 배포 서비스 또한 Git-Flow를 사용했기 때문에 앞서 이야기한 불편함을 다 겪은 뒤 배포가 가능했습니다. 또한 실제 배포 시 `kubectl set image` 명령을 통해 Kubernetes Deployment 중 application container의 image tag만을 변경했기 때문에, 이를 제외한 변경은 개발자가 Kubernetes dashboard에 접속하거나 [kubectl](https://kubernetes.io/docs/reference/kubectl/overview/)과 같은 CLICommand Line Interface를 사용하여 직접 수정했어야 했습니다. 이로 인해 설정 변경 사항을 추적하기가 힘들어졌고, 설정 오류 등의 human fault가 많이 발생할 수밖에 없었습니다.

이처럼 기존의 개발 프로세스는 조직이 커지면서 더 많은 고통을 야기했고 개발자에게 실수할 여지를 많이 제공했습니다. 우리는 이렇게 많은 pain point를 발생시키는 기존 프로세스를 변경하기로 하였고, 우리만의 개발 문화에 적합한 새로운 배포 프로세스를 구상했습니다.

------

## Engineering Culture at Banksalad

뱅크샐러드가 추구하는 개발 문화 중 하나는 **“Cross Teams, Cross Repositories.”** 입니다. 체계화된 조직 체계를 가지고 있고 한 명의 개발자는 하나의 작은 조직에 속해있지만, 사용자 경험을 개선하기 위해서라면 본인의 팀 외에도 여러 팀의 여러 Repository의 코드를 직접 수정할 수 있어야 합니다. 이렇게 팀, 언어, 프레임워크, 비즈니스 도메인 등 제한 없이 기여하고 개선하고 코드 오너에게 리뷰 받으며 자신의 한계를 깨고 동반 성장을 할 수 있는 문화를 가지고 있습니다.

또한 Pull Request를 통한 Code Review 문화가 굉장히 활성화되어 있습니다. 하나의 Repository에는 최소한 3명 이상의 서비스 오너가 존재하며, 모든 PR은 1명 이상의 서비스 오너의 approve를 받아야만 merge 할 수 있습니다. 아래 그래프에서 볼 수 있듯이 뱅크샐러드에서는 지금도 수많은 PR이 열리고, 리뷰되고, 머지되고 있습니다.

[![최근 한 달 간 Pull Request 통계](https://blog.banksalad.com/static/38b8e4191c5f43da6944810f2c244f2e/b9e4f/numbers-of-pull-requests.png)](https://blog.banksalad.com/static/38b8e4191c5f43da6944810f2c244f2e/344b1/numbers-of-pull-requests.png)



**Figure 2 | 최근 한 달 간 Pull Request 통계**



------

## New Deployment Process

기존 배포 프로세스의 pain point를 제거하고 뱅크샐러드만의 개발 문화에 맞게 풀어낸 새로운 배포 프로세스를 소개합니다.

### Lightweight Branching Model

우리는 master branch를 제외한 모든 branch를 제거했습니다. feature, hotfix 등의 모든 작업은 master branch를 base로 하여 만든 새로운 branch에서 작업합니다. branch 이름은 그저 작업할 내용을 명확하게 설명하기만 하면 됩니다. 작업이 완료되면 Pull Request를 열어 서비스 오너들에게 코드 리뷰를 요청합니다. lint와 unit test를 포함한 CI 과정을 통과했고 서비스 오너 한 명 이상의 approve를 받았다면, master branch에 merge 할 수 있습니다.

master branch에 merge 할 때는 `Squash and merge` 방식을 사용합니다. GitHub에서는 총 3가지 merge 방식을 지원하고 있습니다.[[1\]](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/merging-a-pull-request#merging-a-pull-request-on-github) 이는 branch의 모든 commit을 “squash” 해서 하나의 commit으로 만든 뒤 해당 commit을 base branch에 merge 하는 방식입니다. 이를 통해 GitHub에서 제공하는 `Revert Pull Request` 기능[[2\]](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/reverting-a-pull-request)을 활용하여 여러 추가된 기능 중 하나의 기능에서 장애가 발생하더라도 쉽게 롤백할 수 있습니다. 그렇기 때문에 하나의 Pull Request는 배포 가능한 단위여야 합니다. 또한 사이드이펙트를 최소화하기 위하여 작으면 작을수록 좋습니다. 작은 단위의 PR이 활성화되면서 서비스 오너의 리뷰에도 부담 없어져 더 질 좋은 리뷰를 받을 수 있는 긍정적인 사이드이펙트도 발생했습니다.

여기까지는 [GitHub-Flow](https://guides.github.com/introduction/flow/)와 비슷하다고 생각할 수 있습니다. 하지만 GitHub-Flow와의 차이점은 master에 commit이 merge 될 때마다 배포하지 않는다는 것입니다. 이는 조직과 서비스가 커졌을 때를 대비하여 확장성과 유연성을 가지기 위함인데요, 만약 하나의 Repository에 여러 가지 기능이 1분 간격으로 merge 되는 상황일 때, 최신 commit을 계속 배포한다면 어떻게 하면 될까요? 이러한 상황에도 유연성을 가지기 위해서 master에 merge 된 commit을 매번 배포하지 않습니다.

### Commit-Train Based Deployment

위처럼 master branch만 존재하고 이를 base로 새로운 branch를 따서 작은 단위로 작업하고, Pull Request를 열어 리뷰를 받은 뒤 master branch에 바로 squash merge하고 merge 된 commit들을 모아 배포하는 방식으로 일합니다. 이때 master에는 배포 가능한 단위의 여러 커밋이 나열되게 됩니다. 이런 배포되지 않은 커밋들을 여러 개를 모아서 한 번에 배포하게 됩니다.

이 모습이 마치 역에서 여러 량의 기차가 정차해 있다가 출발하는 모양과 비슷해서 `Commit-Train Based Deployment`라는 명칭이 붙었다고 합니다. 물론 아무리 작은 단위의 PR이라지만 commit을 쌓아놨다가 배포하려고 할 때 발생할 수 있는 사이드이펙트나 커뮤니케이션 비용을 줄이기 위해 master에 merge 된 commit은 최대한 빠르게 배포하는 것을 권장하고 있습니다. 이렇게 master branch에서 각기 다른 commit들이 production, staging, development, testing 등 여러 환경에 배포됩니다.

------

## GitHub Deployments & Actions

위 배포 프로세스를 빠르게 구현하기 위해서 GitHub에서 제공하는 Deployments 기능을 핵심적으로 사용했습니다. GitHub의 Deployments 기능은 특정 branch, SHA 혹은 tag에 대하여 배포 요청을 생성하는 기능입니다. Deployment 이벤트가 발생하면 배포를 위한 준비 단계를 거치고 실제 배포를 수행합니다. 이를 통해 모든 배포에 대한 성공/실패 여부, 요청 시각, 커밋, 배포 환경, 누가 배포를 수행했는지 등의 모든 정보가 GitHub에 기록됩니다. 이것을 database로 활용하면 빠르게 개발할 수 있다고 판단하였고, 추후 별도의 DB가 필요할 때 간단히 migration 가능하므로 확장성에도 문제가 없다고 판단했습니다.

GitHub Deployments를 사용하면서 자연스럽게 travis CI 대신 [GitHub Actions](https://help.github.com/en/actions)를 사용하게 되었습니다.

[![GitHub Actions](https://blog.banksalad.com/static/b46179103b1b56e7517e21e5587037d7/b9e4f/actions.png)](https://blog.banksalad.com/static/b46179103b1b56e7517e21e5587037d7/6ff5e/actions.png)



**Figure 3 | GitHub Actions**



CDContinuous Delivery Pipeline을 GitHub으로 관리하게 되면서 자연스럽게 CIContinuous Integration Pipeline 또한 GitHub를 사용하게 되었습니다. 앞서 말했듯이 개발 조직 내에서 Pull Request 문화가 매우 활성화되어 있는 데다가, 기존에 travis CI 등으로 분산되어 있던 관리 포인트가 GitHub 하나로 일원화되면서 개발자의 편의성이 더욱 증대되었습니다. 또한 GitHub Enterprise 플랜을 사용하고 있어 travis CI보다 동시에 더 많은 잡을 수행할 수 있어[[3\]](https://help.github.com/en/actions/getting-started-with-github-actions/about-github-actions#usage-limits) 서비스가 많아져도 서로 blocking 없이 진행할 수 있었습니다.

### Infrastructure as Code

먼저 개발자가 Kubernetes cluster에 직접 접근하지 않고 kubernetes objects를 바로 배포할 수 있도록 모든 yaml 형식의 object 파일들은 repository 내부에서 관리하도록 했습니다. 또한 환경별로 Configmap과 Secrets를 다르게 사용할 수 있도록 [gomplate](https://docs.gomplate.ca/)라는 template engine을 사용해서 구성했습니다. Secrets 관리는 GitHub Secrets 기능을 활용하여 저장하고, 이를 actions에서 환경변수로 가져와서 template에 주입하도록 했습니다.[[4\]](https://help.github.com/en/actions/configuring-and-managing-workflows/creating-and-storing-encrypted-secrets) [Kustomize](https://github.com/kubernetes-sigs/kustomize)도 고려했지만 결국 도입하지 않게 되었습니다. 컨셉 자체는 훌륭했지만 이를 잘 사용하기 위해선 러닝 커브가 높다고 판단하였기 때문입니다. 중앙 집중된 팀에서 관리하는 것이 아닌, 모든 서비스의 모든 개발자가 오너십을 가지고 각각 관리하는 상황에서 높은 러닝 커브는 유지보수를 어렵게 할 가능성이 높다고 판단했습니다. 또한 충분히 작은 크기의 서비스를 유지하기 때문에 굳이 Kustomize를 쓰지 않더라도 하나의 템플릿으로도 어렵지 않게 관리 가능했습니다.

### GitHub Actions

CI, CD를 위한 2가지 workflow를 생성했습니다.

#### Build

Continuous Integration Pipeline을 위한 workflow입니다. 서비스마다 세부적인 것은 다르지만 공통으로 코드 스타일을 검사하는 `lint`, 유닛 테스트를 실행하는 `test`, docker image를 build 하는 `build` step을 정의했습니다. build 과정에서 현재 commit의 SHA를 image tag로 가지는 docker image가 build 되고 docker hub에 push 됩니다. 모든 push마다 lint, unit test, build가 동시에 실행되는데, 이는 개발자에게 최대한 빠르게 피드백을 주기 위함입니다. 세 가지 스텝을 포함한 모든 스텝이 정상적으로 종료되어야 하며, 이 과정을 통과하지 못한 commit은 merge 될 수도 없으며 배포 될 수도 없습니다.

#### Deploy

Continuous Delivery Pipeline을 위한 workflow입니다. GitHub Deployments event가 발생했을 때 실행됩니다. 위 Build workflow를 통과하지 못한 commit이면 배포하지 않고 즉시 실패합니다. 각 step 진행될 때마다 deployment status를 변경 시켜 가면서 최종적으로 deployment status를 success 혹은 failure로 변경합니다. 이로 인해 모든 기록은 GitHub Deployments history에 저장됩니다. 실제 deployment 과정은 kubectl 툴을 사용해 kubernetes cluster에 접속하여, GitHub Secrets와 함께 template engine을 실행 시켜 최종 결과물을 apply 하게 됩니다. 대략적인 sequence diagram은 아래와 같습니다.

ToolingGitHubGitHub ActionsKubernetes ClusterCreate DeploymentDeployment CreatedDeployment EventRender Templatekubectl applyDeployment StatusDeploy CompletedDeployment StatusToolingGitHubGitHub ActionsKubernetes Cluster

**Figure 4 | GitHub Actions를 활용한 배포 sequence diagram**



------

## Deploy & Deploybot

위 과정을 적용한 뒤 [GitHub slack integration](https://slack.github.com/)을 사용하여 실제로 Commit-Train Based Deployment가 가능했습니다. 하지만 GitHub ref는 branch, tag, SHA 3종류가 있음에도 불구하고 branch, tag를 활용한 배포만 가능했고, 커밋 SHA만을 가지고는 배포할 수 없었습니다. 이 때문에 이전 특정 commit으로 롤백이 필요한 경우 바로 대응할 수 없었고 별도의 롤백 branch를 만들어 배포했어야 하는 단점이 존재했습니다. 또한 branch 또는 tag가 매우 많은 Repository는 slack modal이 열리지 않아서 배포할 수 없는 버그도 있었습니다.

따라서 기존 요구 사항인 1. commit 단위로 배포할 수 있고 2. commit 별로 현재 배포된 환경을 한눈에 파악하고 3. 환경별 배포 히스토리를 볼 수 있어야 한다. 이 3가지를 만족하는 내부 ChatOps 툴을 개발하기로 했습니다. 다행히도 [GitHub API](https://developer.github.com/v3/)가 매우 잘 되어 있어 이를 조합해서 활용하는 것으로 구현에는 무리가 없었습니다.

이를 위해 실제 deployment 로직을 담고 있는 서비스인 `deploy`와, 이를 활용한 slackbot interface인 `deploybot`, 2가지 서비스를 개발했습니다. 이는 나중에 web 등 여러 인터페이스가 추가될 확장성을 고려하여 관심사 분리를 적용한 것입니다. 두 서비스 모두 golang을 사용해서 작성했습니다. golang은 뱅크샐러드 내에서 주로 사용되고 있는 언어 중 하나이고, goroutine 등으로 다양한 API를 비동기적으로 사용하는 데에 활용하기 좋다고 판단했기 때문입니다. 또한 서비스간 통신은 gRPC와 protobuf를 사용했기 때문에 손쉽게 병렬 작업이 가능했습니다.

`deploybot`은 Slack slash command 대신 Slackbot으로 구현했습니다. 이는 slash command의 경우 본인만 이력을 볼 수 있고 channel에는 이력이 남지 않아 나중에 추적할 수 없기 때문입니다. 실제 구현된 `deploybot`의 기능은 다음과 같습니다.

### Status

```
@deploybot status {repo} {limit:=5}
```

[![@deploybot status](https://blog.banksalad.com/static/0e28b6111665e5508335b965efe4576a/b9e4f/status.png)](https://blog.banksalad.com/static/0e28b6111665e5508335b965efe4576a/c1867/status.png)



**Figure 5 | @deploybot status**



주어진 repository의 master 브랜치의 최신 커밋들을 나열합니다. 각 커밋의 short SHA, 커밋 메시지, 커밋의 상태, 커밋이 배포된 환경을 보여줍니다. 커밋의 상태는 GitHub commit status checks의 여부에 따라 성공, 실패 혹은 검사 진행 중으로 나타납니다. 만약 현재 배포된 커밋이 있다면 아래에 배포된 환경을 표시합니다. 기본적으로는 5개의 커밋을 보여주지만, limit을 조절하면 최대 50개까지 볼 수 있습니다.

### Deploy

```
@deploybot deploy {repo} {env} {sha}
```

[![@deploybot deploy](https://blog.banksalad.com/static/d972d3ddf6502e5f53eb6a60e39116a8/b9e4f/deploy.png)](https://blog.banksalad.com/static/d972d3ddf6502e5f53eb6a60e39116a8/cc3b5/deploy.png)



Figure 6 | @deploybot deploy



주어진 repository의 sha에 해당하는 커밋을 env에 배포합니다. GitHub commit status checks를 통괴한 커밋만 배포할 수 있습니다. 어떠한 커밋이든 status check가 통과했다면 어떤 환경이든 배포할 수 있습니다. 해당 커맨드가 실행되면 deploy 서비스는 GitHub API를 통해 deployment를 생성합니다.

deploybot에서는 추후 트래킹을 위해 배포를 요청한 개발자를 태그하고, 배포 후 모니터링을 좀 더 쉽게 하기 위해 dashboard 링크를 첨부해서 응답합니다. 이후 build workflow에서 step 별로 변경되는 deployment status를 실시간으로 채널에서 확인할 수 있습니다. 이는 GitHub slack integration의 organization 단위의 subscription을 활용하여 구현했습니다.

### History

```
@deploybot history {repo}
```

주어진 repository의 배포 이력을 환경별로 나열합니다. 최근 수행된 배포의 성공, 실패 여부, 배포된 시각, 커밋, 환경, 누가 배포를 수행했는지 볼 수 있습니다. 디자인은 Art of Unix Programming 원칙에 따라 가장 간단하게 구성해보았습니다.

[![@deploybot history](https://blog.banksalad.com/static/6ecc8321b2b1dd8fea61ac30a8a19916/b9e4f/history.png)](https://blog.banksalad.com/static/6ecc8321b2b1dd8fea61ac30a8a19916/cac38/history.png)



**Figure 7 | @deploybot history**



모든 상황을 위 3가지 커맨드로 사용할 수 있습니다. 예를 들어 서비스에 문제가 생겼을 때 롤백하는 시나리오를 생각해보겠습니다. status 커맨드를 통해 현재 어떤 commit까지 배포되어 있는지 확인하고, history 커맨드를 통해 이전에 배포된 커밋을 확인합니다. 이 커밋을 다시 deploy 커맨드를 통해 배포합니다. 이런 식으로 모든 상황에 다양하게 활용될 수 있습니다. 마지막으로 help 커맨드가 빠질 수 없겠죠. 위 3가지 커맨드와 사용법은 언제든지 `@deploybot help` 로 확인 가능합니다. 아래처럼요.

[![@deploybot help](https://blog.banksalad.com/static/844dae155b963353b25d428a33d445d6/b9e4f/help.png)](https://blog.banksalad.com/static/844dae155b963353b25d428a33d445d6/bda01/help.png)



**Figure 7 | @deploybot help**



------

## Result

이러한 새로운 배포 프로세스 도입의 결과입니다.

먼저 배포에 필요한 스텝을 기존과 비교했을 때 최소 60%에서 83%까지 줄였고, 병목 과정을 없앴습니다. 이를 통해 결과적으로 더 적은 리소스와 더 빠른 시간 안에 더 많은 배포를 수행할 수 있었습니다.

AfterBeforeGitHub Actions 작성GitHub Secrets 설정코드 작성k8s 템플릿 생성travis 파일 작성travis 환경 변수 설정코드 작성배포 서비스 코드 수정PR 후 리뷰 후 머지배포 서비스 배포k8s object 수정배포

**Figure 8 | 프로세스 개선 전후 배포 과정**



그리고 배포가 얼마나 활발해졌나 보기 위해 실제 배포 건수를 확인하기 위하여 앞서 말했던 배포 전용 채널에서 트리거된 배포 건수 추이를 시각화해 봤습니다.

> 배포 건수 집계는 스크립트를 이용해 진행했으며 Slack 채널의 대화록을 추출하여 각각 봇에서 특징적으로 사용되는 문자열로 필터링해 같은 조건으로 집계했습니다.

[![최근 6개월 간 배포 횟수](https://blog.banksalad.com/static/41c3d75afbcdf151c0627442908ab95c/b9e4f/chart.png)](https://blog.banksalad.com/static/41c3d75afbcdf151c0627442908ab95c/34e8a/chart.png)



**Figure 9 | 최근 6개월 간 배포 횟수**



파란색은 기존에 배포한 횟수이고, 빨간색이 새로운 deploybot으로 배포된 횟수입니다. 새로운 deploybot은 11월 3일부터 사용되었는데 1달도 되지 않아 이전 6개월 동안 발생했던 배포 건수를 따라잡았습니다. 이는 이전에 비해 약 4배 증가한 수치입니다. 가장 배포를 자주 하는 서버 개발로 특정해서 본다면, 이때 서버 개발자는 약 10명이었으니 이는 곧 서버 개발자 1명이 하루에 약 5번의 배포를 수행하고 있다는 것을 알 수 있었습니다.

배포가 잦기 때문에 장애가 빈번하게 발생할 수 있다고 오해할 수 있으나, `deploy`와 `rollout` 을 구분해서 다루고 있기 때문에 장애는 거의 발생하지 않습니다. 현재 뱅크샐러드는 rollout 과정을 내부 in-house experiment platform을 사용해서 관리하고 있습니다. 계속해서 옵저버빌리티Observability 툴로 모니터링하며 점진적으로 rollout 해나가는 과정을 모두 코드로 관리하고 있습니다. 이로 인해 잦은 배포에도 불구하고 높은 안정성을 보장할 수 있었습니다. 또한 개발 과정에서도 테스트를 할 수 있도록 각 Pull Request마다 통합 테스트 환경 구축하는 것을 준비 중입니다.

### Further Consideration

이처럼 성공적인 결과물을 얻었지만, 현재 배포 프로세스가 모든 상황을 만족하는 것은 아닙니다. 몇 가지 추후 고려사항이 존재합니다.

- 모든 배포 기능이 GitHub에 강하게 의존하고 있습니다. 실제로 몇 번의 GitHub 장애로 인하여 배포를 할 수 없는 상황이 발생했습니다. 또한, GitHub API 사용에 제한이 있다는 점도 한계점입니다.
- 배포 시 다른 서비스의 배포를 막을 필요가 있을 수 있습니다. 이를 위하여 `lock` 커맨드가 필요하고 이를 해제하기 위한 `unlock` 커맨드가 추가될 예정입니다.
- master branch에 merge 되었으나 오랫동안 배포되지 않은 commit에 대한 Slack 알림 기능을 추가할 예정입니다. 이는 GitHub Actions에서 scheduled workflow를 통해 구현할 수 있습니다.
- 운영 환경별 배포 채널을 분리할 필요가 생기고 있습니다. 서비스가 많아지면서 하나의 채널에 너무 많은 메시지가 발생합니다. 환경별 서비스들 배포 이력을 빠르게 확인할 수 있도록 구분이 필요해졌습니다.
- GitHub deployment status로는 배포 요청이 성공적으로 시작되었는지만 판단할 수 있고, 실제로 성공적으로 완료되었는지는 판단할 수 없습니다. 이는 kubectl rollout 기능을 사용해서 구현 가능합니다.

------

## Conclusion

개발 조직에서 배포 횟수는 비즈니스 요구를 충족시키는 역량과 비례합니다. 스타트업처럼 비즈니스 요구가 자주 변하는 상황에서 사용자에게 더 많은 가치를 빠르게 제공하려면 `배포`는 자신감 있고 자연스럽게 이루어져야 합니다.

실리콘밸리 테크 기업들은 다양한 모니터링 툴과 장애 대응 프로세스를 마련해 배포에 대한 자신감을 높여 조직의 비즈니스 역량을 키우고 있습니다. 처음에 소개한 듯이 **“하루에 1,000번의 배포를 할 수 있는가?”** 는 조직의 기술적 확장 역량을 판단할 수 있는 중요한 지표입니다.

이런 맥락 아래에 우리는 하루에 크고 작은 배포를 1,000번 이상 할 수 있는 조직으로 변화를 꾀했습니다. 기존의 배포 프로세스를 유지하며 변화하기에는 많은 고통이 있었고, 이를 우리의 개발 문화에 맞춰 새로운 배포 프로세스로 개선하였습니다. 결과적으로 새로운 배포 프로세스로 인해 기존에 대비하여 4배 이상의 배포를 하게 되는 성과를 이뤘습니다.

>출처
>
>https://blog.banksalad.com/tech/become-an-organization-that-deploys-1000-times-a-day/?gclid=CjwKCAjw4rf6BRAvEiwAn2Q76lzd7gib6N0I-DISqgU2Hw9WZn-rB_pt7wuoSZIUlDb_8_vc7eDTpBoCwWUQAvD_BwE