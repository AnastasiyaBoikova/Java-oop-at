package Lesson1;

public class Wall extends Barrier {

    int height;

    public void move(Move obj) {
        obj.jumpWall();
    }

//    public boolean move1(Move obj) {
//       if(obj.jumpWall2(height)){
//           return true;
//       }else
//           return false;
//
//
//    }

}
