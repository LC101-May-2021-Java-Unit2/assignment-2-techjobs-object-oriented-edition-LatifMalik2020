package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    public JobTest() {

    }

    @Test
    public void testSettingJobId() {
        // define 2 jobs
        Job firstJob = new Job();
        Job secondJob = new Job();
        // verify that ids of the two jobs are distinct
        Assert.assertNotEquals(firstJob.getId(), secondJob.getId());

    }

    //Test the Full Constructor
    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(true);
        Assert.assertEquals("Product tester", jobTest.getName());
        Assert.assertTrue(jobTest.getEmployer() instanceof Employer);
        Assert.assertEquals("ACME", jobTest.getEmployer().getValue());
        Assert.assertTrue(jobTest.getLocation() instanceof Location);
        Assert.assertEquals("Desert", jobTest.getLocation().getValue());
        Assert.assertTrue(jobTest.getPositionType() instanceof PositionType);
        Assert.assertEquals("Quality control", jobTest.getPositionType().getValue());
        Assert.assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals("Persistence", jobTest.getCoreCompetency().getValue());

    }

    // Test The Equal Method
    //Two Job objects are considered equal if they have the same id value, even if one or more of the other fields differ. Similarly, the two objects are NOT equal if their id values differ, even if all the other fields are identical.

    /* //In JobTest, define a test called testJobsForEquality.
    // Generate two Job objects that have identical field values EXCEPT for id. Test that equals returns false.

    // It might seem logical to follow up the false case by testing to make sure that equals returns true when two objects have the same ID. //However, the positive test is irrelevant in this case.

     //The way you built your Job class, each id field gets assigned a unique value, and the class does not contain a setId method. You also //verified that each new object gets a different ID when you tested the constructors. Without modifying the constructors or adding a setter, //there is no scenario in which two different jobs will have the same ID number. Thus, we can skip the test for this condition*/
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(job1.equals(job2));
    }

    //Create First Test for toString¶
//When passed a Job object, it should return a string that contains a blank line before and after the job information.
//The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String result = jobTest.toString();
        char result1 = result.charAt(0);
        Assert.assertEquals('\n', result1);
        Assert.assertEquals('\n', result.charAt(result.length() - 1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Assert.assertEquals("\nID: " + jobTest.getId() +
                "\nName: " + jobTest.getName() +
                "\nEmployer: " + jobTest.getEmployer().getValue() +
                "\nLocation: " + jobTest.getLocation().getValue() +
                "\nPosition Type: " + jobTest.getPositionType().getValue() +
                "\nCore Competency: " + jobTest.getCoreCompetency().getValue() + "\n", jobTest.toString());


    }
    @Test
    public void testToStringHandlesEmptyField(){

        Job jobTest = new Job("", new Employer (""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Assert.assertEquals( "\nID: " + jobTest.getId() +
                "\nName: " + "Data not available" +
                "\nEmployer: " + "Data not available" +
                "\nLocation: " + "Data not available" +
                "\nPosition Type: " + "Data not available" +
                "\nCore Competency: " + "Data not available" + "\n", jobTest.toString());

    }
}
