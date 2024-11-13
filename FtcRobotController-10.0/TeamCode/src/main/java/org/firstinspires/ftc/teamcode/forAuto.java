package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous
public class forAuto extends LinearOpMode {

    DcMotorEx leftFront;
    DcMotorEx rightFront;
    DcMotorEx leftBack;
    DcMotorEx rightBack;



    @Override
    public void runOpMode() {
        leftFront = hardwareMap.get(DcMotorEx.class,"lf");
        leftBack = hardwareMap.get(DcMotorEx.class,"lb");
        rightBack = hardwareMap.get(DcMotorEx.class,"rb");
        rightFront = hardwareMap.get(DcMotorEx.class,"rf");
        rightFront.setDirection(DcMotorEx.Direction.REVERSE);
        rightBack.setDirection(DcMotorEx.Direction.REVERSE);
        leftBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        leftBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        leftBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        waitForStart();
        if (opModeIsActive()) {
            setVelocity(50);
            sleep(12000);
            setVelocity(0);

        }

    }

    public void setPower(double v1, double v2, double v3, double v4) {
        rightBack.setPower(v1);
        rightFront.setPower(v2);
        leftBack.setPower(v3);
        leftFront.setPower(v4);
    }
    public void forward(double speed){
        rightBack.setPower(speed);
        rightFront.setPower(speed);
        leftBack.setPower(speed);
        leftFront.setPower(speed);
    }
    public void backwards(double speed){
        rightBack.setPower(-speed);
        rightFront.setPower(-speed);
        leftBack.setPower(-speed);
        leftFront.setPower(-speed);
    }
    public void strafeLeft(double speed){
        rightBack.setPower(-speed);
        rightFront.setPower(-speed);
        leftBack.setPower(speed);
        leftFront.setPower(speed);
    }
    public void strafeRight(double speed){
        rightBack.setPower(speed);
        rightFront.setPower(-speed);
        leftBack.setPower(-speed);
        leftFront.setPower(speed);
    }

    public void turnLeft(double speed){
        rightBack.setPower( -speed);
        rightFront.setPower(speed);
        leftBack.setPower(speed);
        leftFront.setPower(-speed);
    }
    public void turnRight(double speed){
        rightBack.setPower(-speed);
        rightFront.setPower(-speed);
        leftBack.setPower(speed);
        leftFront.setPower(speed);

    }
    public void setVelocity(double velociy){
        rightBack.setVelocity(velociy);
        leftBack.setVelocity(velociy);
        rightFront.setVelocity(velociy);
        leftFront.setVelocity(velociy);
    }
}

