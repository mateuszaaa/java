package com.company;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Intersection{
    public Circle c1;
    public Circle c2;

    Intersection(Circle c1, Circle c2){
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public boolean equals(Object o){
        if (o == this){ return true; }
        if (!(o instanceof Intersection)){return false; }
        Intersection inter = (Intersection) o;
        if (c1.equals(inter.c1) && c2.equals(inter.c2)){return true;}
        if (c1.equals(inter.c2) && c2.equals(inter.c1)){return true;}
        return false;
    }

    @Override
    public int hashCode(){
        return c1.hashCode() + c2.hashCode();
    }
}

class Circle{
    final private Integer x;
    final private Integer r;
    Circle(Integer x_pos, Integer radius)
    {
        x = x_pos;
        r = radius;
    }

    Boolean interselect(Circle c){
        Integer a1 = x;
        Integer r1 = r;
        Integer a2 = c.x;
        Integer r2 = c.r;

        Double common_x = (double) (r2 * r2 - r1 * r1 - a2 * a2 + a1 * a1)/(double)(2*a1-2*a2);
        Boolean in_first_circle = (common_x <= a1+r1) && (common_x >= a1-r1);
        Boolean in_second_circle = (common_x <= a2+r2) && (common_x >= a2-r2);
        if (in_first_circle && in_second_circle){
            return Boolean.FALSE;
        }else{
            return Boolean.FALSE;
        }
    }

    @Override
    public int hashCode(){
        return 31*x.hashCode() + 23*r.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if (o == this){ return true; }
        if (!(o instanceof Circle)){ return false; }
        Circle circle = (Circle) o;
        return this.r.equals(circle.r) && this.x.equals(circle.x);
    }
}

class Solution {
    public int solution(int[] A) {
        return  0;
    }
}

class Test{
    static void assert_true(Boolean b){
        if (b == Boolean.FALSE){
            throw new AssertionError();
        }
    }
    static void assert_false(Boolean b){
        assert_true(!b);
    }

    static void assert_equals(Object o1, Object o2){
        assert_true(o1.equals(o2));
    }

    static void assert_not_equals(Object o1, Object o2){
        assert_false(o1.equals(o2));
    }
}

public class Main {

    public static void main(String[] args) {
        Circle c1 = new Circle(2, 3);
        Circle c2 = new Circle(3, 2);
        Intersection i1 = new Intersection(c1,c2);
        Intersection i2 = new Intersection(c2,c1);

        // TEST
        Test.assert_equals(new Circle(1,1), new Circle(1,1));
        Set<Circle> circle_set = new HashSet<Circle>();
        circle_set.add(new Circle(1, 1));
        circle_set.add(new Circle(1, 1));
        Test.assert_equals(circle_set.size(), 1);
        // TEST
        Set<Intersection> intersection_set = new HashSet<Intersection>();
        Intersection i3 = new Intersection(new Circle(1,2), new Circle(2,1));
        Intersection i4 = new Intersection(new Circle(2,1), new Circle(1,2));
        Test.assert_equals(i3,i4);
        intersection_set.add(i3);
        intersection_set.add(i4);
        Test.assert_equals(intersection_set.size(),1);
    }
}


