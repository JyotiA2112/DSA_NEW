package code.LLD;

public class FactoryPattern {

    public static void main(String[] args) {
        Course lld = CourseFactory.getCourse("code/LLD");
        Course hld = CourseFactory.getCourse("HLD");

        System.out.println(lld.courseName);
        System.out.println(hld.courseName);

    }





}


abstract class CourseFactory{

    public static Course getCourse(String courseType)
    {
        if(courseType == "code/LLD")
        {
            return new LLD();
        }

        if(courseType == "HLD")
        {
            return new HLD();
        }

        return null;
    }

}

abstract class Course
{
    abstract void getCourses();
    String courseName;

    void Course(){
        this.getCourses();
    }


}

 class LLD extends Course{

    @Override
    void getCourses() {
        this.courseName = "LLD course";
    }
}
 class HLD extends Course{

    @Override
    void getCourses() {
        this.courseName = "HLD course";
    }
}