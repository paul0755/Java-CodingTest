💡 놓친 부분
1. substring()
int idx = pt.indexOf('*')로 별 위치를 인덱스를 잡고
String last = pt.subString(pt길이 - idx)를 진행하였는데 예시에서는 잘돌아가였지만
만일 *이 맨앞에 있거나 했을때, StringOutOfBoundary 오류가 발생하게되었다.
더 쉬운 방법인
String last = pt.subString(idx+1)이 있음을 몰랐다 ㅠ

2. 입력값이 패턴의 길이보다 짧을때
입력 문자열이 패턴의 길이보다 짧을 경우도 있을수 있는것을 몰랐다.
String tmp = br.readLine();
if(tmp.length() < first_length() + Last_length()) 일경우에는 패턴을
비교할수없기에 불일치인 'NE'를 출력하고 continue를 해줬어야했다.
