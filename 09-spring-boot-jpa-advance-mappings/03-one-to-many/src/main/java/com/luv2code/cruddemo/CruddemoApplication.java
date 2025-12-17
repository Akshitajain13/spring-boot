package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.aspectj.apache.bcel.generic.Instruction;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner->{
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            //DeleteInstructor(appDAO);
            //findInstructorDetail(appDAO);
            //deleteInstructorDetail(appDAO);
            //createInstructorWithCourses(appDAO);
            //findInstructorWithCourses(appDAO);
            //findCoursesForInstructor(appDAO);
            //findInstructorWithCoursesJoinFetch(appDAO);
            //updateInstructor(appDAO);
            //updateCourse(appDAO);
            //DeleteInstructor(appDAO);
            DeleteCourse(appDAO);

        };
}

    private void DeleteCourse(AppDAO appDAO) {
        int theId =10;
        System.out.println("Deleting course id:" +theId);
        appDAO.deleteByCourse(theId);
        System.out.println("DONE");
    }


    private void updateCourse(AppDAO appDAO) {
        int theId=10;
        //find the course
        System.out.println("FInding Course id: " +theId);
        Course tempCourse = appDAO.findCourseById(theId);
        //update the course
        System.out.println("Updating course id:" +theId);
        tempCourse.setTitle("Coding ");
        appDAO.update(tempCourse);
        System.out.println("DONE");

    }

    private void updateInstructor(AppDAO appDAO) {
        int theId=1;
        //find the instructor
        System.out.println("Finding Instructor id" +theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        //update the instructor
        System.out.println("Updating Instructor id:"+theId);
        tempInstructor.setLastName("TESTER");
        appDAO.update(tempInstructor);
        System.out.println("DONE");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int theId=1;
        //find the instructor
        System.out.println("Finding instructor id:" +theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
        System.out.println("tempInstructor:" + tempInstructor);
        System.out.println("the associated courses;" + tempInstructor.getCourses());
        System.out.println("Done");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId=1;
        System.out.println("Finding Instructor id:" + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor" + tempInstructor);
        //find courses for instructor
        System.out.println("Finding courses fir instructor id: " + theId);
        List<Course> courses =appDAO.findCoursesByInstructorId(theId);
        //associate the objects
        tempInstructor.setCourses(courses);
        System.out.println("the associated courses:" + tempInstructor.getCourses());
        System.out.println("DONE");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId=1;
        System.out.println("Finding Instructor id:" + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor" + tempInstructor);
        System.out.println("the associated courses:" + tempInstructor.getCourses());
        System.out.println("DONE");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        //create the instructor
        Instructor tempInstructor =
                new Instructor("Susan","Pho","Susan423ph@luv2code.com");

        //create the Instructor Detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail("http://www.luv@code/youtube","Basketball");

        //associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        //create some courses
        Course tempCourse1 =new Course("Air Guitar");
        Course tempCourse2 =new Course("Chess");
        Course tempCourse3 =new Course("Pinball Masterclass");

        //add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);
        tempInstructor.add(tempCourse3);

        // save the instructor
        //
        //NOTE: ths will ALSO save the courses
        // because of cascadeType.PERSIST
        //
        System.out.println("Saving Instruction"+tempInstructor);
        System.out.println("The Courses: "+tempInstructor.getCourses());
        appDAO.save(tempInstructor);
        System.out.println("DONE");

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId=2;
        System.out.println("Deleting instructor Detail id:" + theId);
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done");

    }

    private void findInstructorDetail(AppDAO appDAO) {
        //get the instructor detail object
        int theId =2;
        InstructorDetail tempInstructorDetail =appDAO.findInstructorDetailById(theId);
        //print the instructor detail
        System.out.println("tempInstructorDetail:" + tempInstructorDetail);
        //print the associated instructor
        System.out.println("the associated instructor" + tempInstructorDetail.getInstructor());
        System.out.println("DONE");
    }

    private void DeleteInstructor(AppDAO appDAO) {
        int theId=1;
        System.out.println("Deleting instructor id:" + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done");
    }

    private void findInstructor(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id" +theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor" + tempInstructor);
        System.out.println("the associated instructorDetail only:" +tempInstructor.getInstructorDetail());

    }
/*
    private void createInstructor(AppDAO appDAO) {
        //create the instructor
        Instructor tempInstructor =
                new Instructor("chad","joseph","chad123joseph@luv2code.com");

        //create the Instructor Detail
        InstructorDetail tempInstructorDetail =
                new InstructorDetail("http://www.luv@code/youtube","badminton");
 */
        private void createInstructor(AppDAO appDAO) {
            //create the instructor
            Instructor tempInstructor =
                    new Instructor("Mandy","philip","Mandy3423philip@luv2code.com");

            //create the Instructor Detail
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.luv@code/youtube","Chess");

        //associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);
        //saving the instructors
        //NOTE: this will ALSO save the details object
        //because of CascadeType.ALL
        //
        System.out.println("Saving Instruction"+tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("DONE");

    }
}
