package com.ll.level0.p87377;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
}

class Solution {
    public String[] solution(int[][] line) {

        Points points = intersections(line);
        // 교점들 구하고
        char[][] matrix = points.toMatrix();
        // 매트릭스로 옮긴다.

        return drawOnCoordinate(matrix);
    }

    Point intersection(int[] line1, int[] line2) {
        // line1과 line2가 들어오면 교점을 구하는 메서드

        // Ax + By + E = 0
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        // Cx + Dy + F = 0
        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = A * D - B * C;
        // 문제에서 제공된 식 중 분모 부분이 공통되기 때문에 변수로 선언


        if (divisor == 0) return null;
        // 이 경우 평행해서 교점이 없다.

        double x = (B * F - E * D) / divisor;
        double y = (E * C - A * F) / divisor;
        // 문제에서 제공된 교차점을 구하는 공식

        if (x != (long) x) return null;
        // 문제에서 정수좌표만 구하라고 했으니 (long) x와 같은지 확인해서 정수가 아닌 것은 null을 반환
        if (y != (long) y) return null;
        // 문제에서 정수좌표만 구하라고 했으니 (long) y와 같은지 확인해서 정수가 아닌 것은 null을 반환

        return Point.of(x, y);
        // Point.of(x, y) 메서드는 new Point(x, y)를 return하는 메서드 -> return Point 객체 : Point 클래스의 생성자는 private이기 때문에 직접 생성할 수 없고, 대신 of 메서드를 통해 생성
    }

    Points intersections(int[][] line) {
        // int 2차원 배열을 받아서 Points로 return 하는 메서드

        Points points = Points.of();
        // Points.of를 Points로 선언 : Points.of()는 매개변수로 받은 Point 객체들을 HashSet에 저장하고, 해당 값을 가진 Points 객체를 생성

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];
                // 이차원 배열의 i 번째 요소인 배열과 j 번째 요소인 배열을 각각 대입(배열에는 선분의 값이 들어 있음)

                Point point = intersection(line1, line2);
                // intersection을 이용해서 해당 line1과 2의 point(교점)을 구함

                if (point != null) points.add(point);
                // point가 비어있지 않으면 points에 해당 값을 추가(Point 객체를 HashSet에 추가)
            }
        }

        return points;
        // 교점들을 points에 전부 추가한 뒤 return
    }

    String[] drawOnCoordinate(char[][] matrix) {
        // char[][]배열(y축을 기준으로 뒤집힌 위치에 * 표시된 배열)을 매개변수로 받으면 다시 역순으로 정렬 후 String으로 변환하는 메서드
        return Ut.revRange(0, matrix.length)
                .boxed()
                .map(i -> matrix[i])
                // revRange로 뒤집힌 행을 역순으로 정렬해서 matrix[4] -> matrix[3] ... 이런 식으로 출력
                .map(row -> new String(row))
                // 위에 뒤집은 값을 행으로 받아 String으로 변환
                .toArray(String[]::new);
                //String 배열로 변환해서 return
    }
}

class Point {
    // Point 클래스의 역할은 좌표 x, y 값을 갖고 있는 역할
    public final long x;
    public final long y;
    // final 변수로 x와 y 선언

    private Point(long x, long y) {
        this.x = x;
        this.y = y;
    } // Point 클래스의 매개변수를 받는 생성자로, x와 y가 들어오면 객체가 해당 x값과 y값을 갖게 됨


    public static Point of(long x, long y) {
        return new Point(x, y);
    } // 정수로 세팅하는 용도 : long x, y가 들어오면

    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    } // 실수로 세팅하는 용도 : double x, y가 들어오면 long을 받는 of 메서드에 x, y를 형변환해서 매개변수로 넣음

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    } // 객체 비교, 가독성 좋음

    @Override
    public int hashCode() {
        int result = (int) (x ^ (x >>> 32));
        result = 31 * result + (int) (y ^ (y >>> 32));
        return result;
    } // 객체 비교, 객체로 부터 고유키를 뽑아낸다.(int), 대량비교 좋음, 가독성 나쁨

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    } // toString 메서드 Override
}

class Points implements Iterable<Point> {
    // Iterable : 인터페이스로, 순회할 수 있는 컬렉션을 나타냄(개체가 for-each 루프를 사용할 수 있음)
    // Collection보다 상위 인터페이스, iterator() 메소드를 구현해야 함
    private final Set<Point> data;
    // data라는 이름의 Point Set을 선언

    private Points(Set<Point> data) {
        this.data = data;
    } // Point Set을 매개변수로 받는 생성자로, 해당 값을 Points의 data에 저장

    public static Points of(Point... pointArray) {
        // Point... 는 Point[] 와 같은 뜻 == Point 객체를 여러 개 받을 수 있음을 의미
        // Point... 의 특수기능 : 가변인자
        // Points.of(arg1);
        // Points.of(arg1, arg2);
        // Points.of(arg1, arg2, agr3);
        return new Points(
                Arrays.stream(pointArray)
                        .collect(Collectors.toCollection(HashSet::new))
        );
        // 입력받은 배열을 HashSet 형태로 하다.
        // Collectors.toSet() 를 사용하지 않는 이유 : 우리는 mutable 한것을 원한다.
        // mutable : 수정 가능
        // immutable : 수정 불가능(add, remove 등이 안됨)
    } // 매개변수로 받은 Point 객체들을 HashSet에 저장하고, 해당 값을 가진 Points 객체를 생성

    public boolean add(Point point) {
        return data.add(point);
    } // data(Set<Point>)에 point 추가

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Points points)) return false;

        return Objects.equals(data, points.data);
    } // equals 메서드 Override

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    } // hashCode 메서드 Override

    @Override
    public Iterator<Point> iterator() {
        return data.iterator();
    } // Iterator는 일반적으로 컬렉션 내의 요소에 대한 반복자를 생성하고 반환(for-each를 사용할 수 있게 함)
    // 반환된 반복자를 사용하여 컬렉션 내의 요소에 반복적으로 액세스하거나 수정할 수 있음

    public Stream<Point> stream() {
        return data.stream();
    } // Points객체 내의 Point 객체들을 Stream으로 반홚

    Point getMinPoint() {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point : data) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }

        return Point.of(x, y);
    } // Point의 값들 중 가장 작은 x와 y 값을 찾는 메서드로 모든 Point들 중 가장 작은 값이 x와 y에 저장됨

    Point getMaxPoint() {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point : data) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }

        return Point.of(x, y);
    } // Point의 값들 중 가장 큰 x와 y 값을 찾는 메서드로 모든 Point들 중 가장 큰 값이 x와 y에 저장됨

    Points positivePoints() {
        Point minPoint = getMinPoint();

        return Points.of(
                data.stream()
                        .map(p -> Point.of(p.x - minPoint.x, p.y - minPoint.y))
                        .toArray(Point[]::new)
        );
    } // 교점의 기준을 0, 0으로 만듦 -> 최소 x, y값을 0, 0으로 만들어야 하기 때문에 모든 점에서 최소 x, y값을 뺌
    // 교점의 분포가 1사분면에 위치해야 다루기가 쉽고, 배열이나 String 인덱스로 표현하기 쉽기 때문에 필요한 처리

    char[][] emptyMatrix() {
        Point minPoint = getMinPoint();
        Point maxPoint = getMaxPoint();

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);
        // 인덱스의 시작이 0이기 때문에 max - min에서 +1을 해야 총 크기가 나옴

        char[][] matrix = new char[height][width];
        // char배열을 위에서 계산한 가로 세로 값을 넣어 생성

        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, '.'));
        //Arrays.stream은 각 행을 stream으로 반환, forEach는 각 행을 하나씩 처리 -> 각 행(row)의 모든 요소를 '.'으로 채워서 초기화

        return matrix;
        // char[][] 배열로 return
    }

    public char[][] toMatrix() {
        char[][] matrix = emptyMatrix();
        // char[][] 배열을 emptyMatrix로 초기화
        Points points = positivePoints();
        // Points는 positivePoints로 초기화(1사분면으로 이동시킨 Points)

        points.forEach(p -> matrix[(int) p.y][(int) p.x] = '*');
        // points 객체에 저장된 모든 좌표 값들을 받아 y, x에 해당하는 위치의 값을 *로 변경 -> 다만 0, 0부터 들어가기 때문에 교점 위치가 뒤집힌 상태로 *이 표시됨
        // 행 기준으로 가장 밑에 있어야 행이 0번이라 가장 위에 있게 됨(행이 반대로 저장)

        return matrix;
        // char[][] 배열로 결과 return
    }
}

class Ut {
    public static IntStream revRange(int from, int to) {
        return IntStream.range(from, to)
                .map(i -> to - i + from - 1);
    } // IntStream.range를 사용하여 from에서 to미만까지의 정수들을 Stream으로 변환 -> map(i -> to - i + from - 1)을 이용해 정수들을 역순으로 정렬하고 return
}