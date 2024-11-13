package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous
public class scuffed extends LinearOpMode {

        DcMotor leftFront;
        DcMotor rightFront;
        DcMotor leftBack;
        DcMotor rightBack;

        static final double HD_COUNTS_PER_REV = 28;
        static final double DRIVE_GEAR_REDUCTION = 3;
        static final double WHEEL_CIRCUMFERENCE = 5.5 * Math.PI;
        static final double DRIVE_COUNTS_PER_INCH = (HD_COUNTS_PER_REV * DRIVE_GEAR_REDUCTION) / WHEEL_CIRCUMFERENCE;

        @Override
        public void runOpMode() {
            leftFront = hardwareMap.dcMotor.get("lf");
            leftBack = hardwareMap.dcMotor.get("lb");
            rightBack = hardwareMap.dcMotor.get("rb");
            rightFront = hardwareMap.dcMotor.get("rf");
            leftFront.setDirection(DcMotor.Direction.REVERSE);
            rightBack.setDirection(DcMotor.Direction.REVERSE);
            leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

            leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            leftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            rightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            leftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            waitForStart();
            if (opModeIsActive()) {
                forward(-0.2);
                sleep(3300);
                forward(0);
                sleep(1000);
                turnLeft(.3);
                sleep(1050);
                forward(0);
                sleep(1000);
                forward(-.2);
                sleep(6000);
                forward(0);

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
    }

