* 그래들 명령어
1. clean
- build 폴더 삭제

2. compileJava
- src/main/java 폴더의 자바 소스를 컴파일 한다.

3. processResources
- src/main/resources 폴더의 내용을 build 폴더에 복사함.

4. classes
- compileJava + processResources

5. build
- 빌드 관련 모든 명령 수행!
- 느리다.
- 개발 중간에는 classes 정도면 된다.
- 개발 완료 후에 build 수행하면 적당한다.


