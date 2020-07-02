# 한 컴퓨터에서 다른 Git 계정 로그인 및 Author 변경

[Win 10 기준]



+ Permission to ~ denied

제어판 - 사용자 계정 - 자격 증명 관리자 - Windows 자격 증명 - git:https://github.com

사용자 이름 , 암호 변경

remote: Permission to jojun94/Workspace.git denied to gwaksuyeon.
fatal: unable to access 'https://github.com/jojun94/Workspace.git/': The requested URL returned error: 403



+ Commit Author 수정

git commit --amend --author="USERNAME <USER-EMAIL>"

Ex) git commit --amend --author="jojun94 <jojun9475@gmaile.com>"

