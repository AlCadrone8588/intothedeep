package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;

import java.util.ArrayList;

@Autonomous
public class redCloseAuto extends LinearOpMode {
    DcMotorEx leftFront;
    DcMotorEx rightFront;
    DcMotorEx leftBack;
    DcMotorEx rightBack;
    int num;
    ArrayList motorsOutput;

    ColorSensor leftColor;

    ColorSensor rightColor;

    Servo autoArm;

    static final double HD_COUNTS_PER_REV = 28;
    static final double DRIVE_GEAR_REDUCTION = 2.7;
    static final double WHEEL_CIRCUMFERENCE = 5.5 * Math.PI;
    static final double DRIVE_COUNTS_PER_INCH = (HD_COUNTS_PER_REV * DRIVE_GEAR_REDUCTION) / WHEEL_CIRCUMFERENCE;


    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotorEx.class,"lf");
        leftBack = hardwareMap.get(DcMotorEx.class,"lb");
        rightBack = hardwareMap.get(DcMotorEx.class,"rb");
        rightFront = hardwareMap.get(DcMotorEx.class,"rf");
        num = 0;
        rightColor = hardwareMap.get(ColorSensor.class, "rightColor");
        leftColor = hardwareMap.get(ColorSensor.class, "leftColor");
        autoArm = hardwareMap.get(Servo.class, "autoArm");
        motorsOutput = new ArrayList(0);
        rightBack.setDirection(DcMotorEx.Direction.REVERSE);
        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
        leftBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        resetEncoder();
        rightBack.setTargetPosition(0);
        leftBack.setTargetPosition(0);
        rightFront.setTargetPosition(0);
        leftFront.setTargetPosition(0);
        autoArm.setPosition(0);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        waitForStart();
        if (opModeIsActive()) {


            runMotors(200,getDistance(1,1,1,1,14.5));
            sleep(1000);
           if(leftColor.red() > 60){
               runMotors(200,getDistance(-1,-1,-1,-1,10));
               sleep(500);
               runMotors(200,getDistance(1,1,-1,-1,14));
               sleep(500);
               runMotors(200,getDistance(1,1,1,1,15));
               sleep(500);
               runMotors(200,getDistance(-1,-1,1,1,20));
               sleep(500);
               runMotors(200,getDistance(1,1,1,1,10));
               sleep(500);
               runMotors(200,getDistance(1,1,-1,-1,16));
               sleep(500);
               runMotors(200,getDistance(1,1,1,1,10));
               sleep(500);
               autoArm.setPosition(1);
               sleep(3000);
               autoArm.setPosition(0);



           }

            else if(rightColor.red() > 55){
                runMotors(200,getDistance(1,1,-1,-1,13));
                sleep(500);
                runMotors(200,getDistance(-1,-1,-1,-1,4));
                sleep(500);
                runMotors(200,getDistance(-1,-1,1,1,12));
                sleep(500);
                runMotors(200,getDistance(1,1,1,1,10));
                sleep(500);
                runMotors(200,getDistance(1,1,-1,-1,13));
                sleep(500);
                runMotors(200,getDistance(1,1,1,1,15));
                sleep(500);
                runMotors(200,getDistance(1,1,-1,-1,18));
                sleep(500);
                runMotors(200,getDistance(1,1,1,1,10));
                sleep(500);
                runMotors(200,getDistance(-1,-1,1,1,15));
                sleep(500);
                runMotors(200,getDistance(1,1,1,1,10));
                sleep(500);
                autoArm.setPosition(1);
                sleep(3000);
                autoArm.setPosition(0);



            }
            else{
               runMotors(200,getDistance(-1,-1,1,1,14));
               sleep(500);
               runMotors(200,getDistance(1,1,1,1,4));
               sleep(500);
               runMotors(200,getDistance(-1,-1,-1,-1,20));
               sleep(500);
               runMotors(150,getDistance(-1,-1,1,1,30));
               sleep(500);
               runMotors(150,getDistance(1,1,1,1,7));
               sleep(500);
               autoArm.setPosition(1);
               sleep(3000);
               autoArm.setPosition(0);
           }
            autoArm.setPosition(0);
            sleep(3000);
            autoArm.setPosition(1);






        }

    }
    private void resetEncoder(){
        leftBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void runMotors(int velociy, ArrayList motorsOutput){

        rightBack.setTargetPosition((int)motorsOutput.get(2));
        leftBack.setTargetPosition((int)motorsOutput.get(1));
        rightFront.setTargetPosition((int)motorsOutput.get(3));
        leftFront.setTargetPosition((int)motorsOutput.get(0));



        rightBack.setVelocity(velociy);
        leftBack.setVelocity(velociy);
        rightFront.setVelocity(velociy);
        leftFront.setVelocity(velociy);
        while (opModeIsActive() && rightBack.isBusy() && leftBack.isBusy() && rightFront.isBusy() && leftFront.isBusy()) {
            num = 3;

        }
        rightBack.setVelocity(0);
        leftBack.setVelocity(0);
        rightFront.setVelocity(0);
        leftFront.setVelocity(0);
    }
    private ArrayList getDistance(int LF,int LB, int RB, int RF,double distance){
        while(0< motorsOutput.size()){
            motorsOutput.remove(0);
        }
        int targetRB = 0;
        int targetLB = 0;
        int targetRF = 0;
        int targetLF = 0;
        targetRB += rightBack.getCurrentPosition() + RB*((int) (distance * DRIVE_COUNTS_PER_INCH));
        targetLB += leftBack.getCurrentPosition() +LB*((int) (distance * DRIVE_COUNTS_PER_INCH));
        targetRF += rightFront.getCurrentPosition() + RF*((int) (distance * DRIVE_COUNTS_PER_INCH));
        targetLF += leftFront.getCurrentPosition() + LF*((int) (distance * DRIVE_COUNTS_PER_INCH));
        motorsOutput.add(targetLF);
        motorsOutput.add(targetLB);
        motorsOutput.add(targetRB);
        motorsOutput.add(targetRF);
        return motorsOutput;
    }
}