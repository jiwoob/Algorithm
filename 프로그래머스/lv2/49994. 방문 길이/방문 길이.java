import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0; // 현재 위치
        HashSet<String> set = new HashSet<>();  //이동한 경로 저장.
        System.out.println();
        
        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            int nx = x, ny = y;

            // 이동할 좌표 계산
            switch (dir) {
                case 'U':  //위로
                    ny = y + 1;
                    break;
                case 'D':  //아래로
                    ny = y - 1;
                    break;
                case 'R':  //오른쪽
                    nx = x + 1;
                    break;
                case 'L':  //왼쪽
                    nx = x - 1;
                    break;
            }

            // 좌표가 범위를 벗어나면 무시
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                continue;
            }

            // 이동 경로 문자열 생성
            String path = x + "" + y + "" + nx + "" + ny;
            String path2 = nx + "" + ny + "" + x + "" + y;
            System.out.println(path);
            
            // 이미 방문한 경로이면 무시
            if (set.contains(path) || set.contains(path2)) {
                x = nx;
                y = ny;
                continue;
            }else{
                // 이동 경로 저장
                set.add(path);
                set.add(path2);
                answer++;
                x = nx;
                y = ny;    
            }


        
        }
        return answer;
    }
}
