# About Merge and Rebase

## git merge

이제 feature 브랜치에서 작업하던 내용이 완성되었다면 master와 합쳐서 실제로 사용할 수 있게 해야합니다. 이 때 사용하는 명령어가 **git merge [브랜치명]**입니다. 주의할 점은 여기서의 브랜치명은 합칠 branch입니다. 바탕이 되는 branch가 아니라요. 우리가 합칠 branch는 feature죠. 따라서 merge 전에 항상 **git branch** 명령어로 현재 HEAD가 바탕이 되는 master에 있나 확인해야 합니다.

merge 후에는 구조가 다음과 같아집니다.

![img](https://cdn.filepicker.io/api/file/2cnMOSMYQAGqHsWfgl1P)

![img](https://cdn.filepicker.io/api/file/0nDhSy28QJaK5emSfL44)

merge 결과에 **Fast-forward**라고 표시되어 있는데 이것은 master 브랜치를 앞으로 쭉 당겼다는 뜻입니다. feature 브랜치가 master 브랜치보다 한 commit 앞에 있었기 때문에 master 브랜치가 feature 브랜치를 merge하는 순간 한 commit 앞으로 당겨지는 거죠.

### conflict

하지만 모든 merge가 이렇게 순조롭게 되는 것은 아닙니다. 가끔 branch끼리 충돌이 나는 경우가 있는데 그 경우를 알아봅시다.

**git reset HEAD~1**으로 master branch를 뒤로 돌려봅시다. 그리고 *git.html*을 다음과 같이 수정하고 commit을 해봅니다.

```jsx
<!DOCTYPE html>
<html>
<head>
  <title>깃 연습</title>
  <link rel="stylesheet" href="./git.css" />
</head>
<body>
  <h1>깃 conflict</h1>
  <p><b>깃 conflict</b>의 사용 방법에 대해 알아봅시다</p>
</body>
</html>
```

![img](https://cdn.filepicker.io/api/file/zW6oeCPR2OL1aBDSuZBA)

![img](https://cdn.filepicker.io/api/file/jJtqqm7HTAaH3poLXk9K)

이제는 branch 두 개가 각자 다른 갈래로 갈라졌습니다. 이제 **git merge feature**을 하면 충돌이 일어나는 것을 볼 수 있습니다.

![img](https://cdn.filepicker.io/api/file/Syf4OjmSBqrgq4W1FmhQ)

또한 *git.html*도 다음과 같이 자동으로 변경되었습니다.

```jsx
<!DOCTYPE html>
<html>
<head>
  <title>깃 연습</title>
  <link rel="stylesheet" href="./git.css" />
</head>
<body>
<<<<<<< HEAD
  <h1>깃 conflict</h1>
  <p><b>깃 conflict</b>의 해결 방법에 대해 알아봅시다</p>
=======
  <h1>깃 브랜치</h1>
  <p><b>깃 브랜치</b>의 사용 방법에 대해 알아봅시다</p>
>>>>>>> feature
</body>
</html>
```

<<<<<<< HEAD와 >>>>>>> feature 사이가 충돌이 발생하는 지점입니다. Conflict commit과 Feature commit의 차이점이기도 하고요. 이 부분을 직접 정상적으로 바꿔주고 **add** 후 **commit** 해줍니다. 이제 갈라졌던 두 브랜치가 하나의 commit으로 다시 합쳐졌습니다.

![img](https://cdn.filepicker.io/api/file/wxjeK1jjTXGKamMoMSop)

## git rebase

두 branch를 합치는 다른 방법은 **git rebase**입니다. 위의 구조에서 **git reset HEAD~1**을 해줍니다. 합쳐졌던 두 개의 브랜치가 다시 갈라졌습니다.

![img](https://cdn.filepicker.io/api/file/jJtqqm7HTAaH3poLXk9K)

두 사람이 협업하다가 commit이 서로 달라진 경우죠. 이제 여기(master)서 feature branch를 rebase합니다. **git rebase [브랜치명]**입니다.

![img](https://cdn.filepicker.io/api/file/KqzTJprSmaJpoQwFEDCL)

역시나 충돌이 일어나는 데 merge와는 해결 방법이 살짝 다릅니다. 일단 *git.html*의 충돌을 해결하고 **git add git.html**로 staged 상태로 만들어줍니다. merge는 그 후에 commit을 했지만, rebase는 **git rebase --continue**로 중단된 rebase를 이어가면 됩니다.

![img](https://cdn.filepicker.io/api/file/hFIlZVomTuir6JDxDN6x)

현재 구조는 다음과 같습니다.

![img](https://cdn.filepicker.io/api/file/wEyUQ6X7T3maYTMdchXC)

merge 때와는 살짝 다르죠? merge는 갈라진 두 commit이 합쳐져서 새로운 commit이 되었다면, rebase는 하나의 commit이 다른 commit 앞으로 올라갑니다. 아래의 merge 경우와 비교해보세요.

![img](https://cdn.filepicker.io/api/file/wxjeK1jjTXGKamMoMSop)

merge와 rebase는 취향에 따라 사용하시면 됩니다. 깔끔한 log를 원하면 rebase를 하고, 직관적으로 간단하게 하고 싶으면 merge를 하면 됩니다.

> 출처
>
> https://www.zerocho.com/category/Git/post/582df1c8d349570018107477