package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class theStart extends LinearOpMode {
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
   // DcMotor lift;
  //  Servo planeLauncher;

    DcMotor arm;
    //DcMotor planeLauncher;

    @Override
    public void runOpMode() {

        leftFront = hardwareMap.dcMotor.get("lf");
        leftBack = hardwareMap.dcMotor.get("lb");
        rightBack = hardwareMap.dcMotor.get("rb");
        rightFront = hardwareMap.dcMotor.get("rf");
        //lift = hardwareMap.dcMotor.get("lift");
        //planeLauncher = hardwareMap.get(Servo.class, "planeLauncher");

        //arm = hardwareMap.dcMotor.get("arm");
        //planeLauncher = hardwareMap.dcMotor.get("planeLauncher");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);





        waitForStart();
        while (opModeIsActive()) {
            double rystick = gamepad1.right_stick_y;
            double rxstick = (gamepad1.right_stick_x)/2.0;
            double lystick = (gamepad1.left_stick_y)/2.0;
            double lxstick = (gamepad1.left_stick_x);
            boolean a = gamepad2.a;
            boolean b = gamepad1.b;
            boolean x = gamepad2.x;
            boolean y = gamepad2.y;
            double lt = gamepad2.left_trigger;
            double rt = gamepad2.right_trigger;

            if(Math.abs(lxstick) > 0 || Math.abs(lystick) > 0 || Math.abs(rxstick) > 0){
                double r = Math.hypot(gamepad1.left_stick_x,gamepad1.left_stick_y);
                double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x)-Math.PI /4;
                double rightX = -gamepad1.right_stick_x;

                double v1 = r * Math.sin(robotAngle) - rightX;
                double v2 = r * Math.cos(robotAngle) - rightX;
                double v3 = r * Math.cos(robotAngle) + rightX;
                double v4 = r * Math.sin(robotAngle) + rightX;

                setPower(v1,v2,v3,v4);

            }
            else if(y) {
               // lift.setPower(1);
            }
            else if(a){
               // lift.setPower(-1);
            }

            else if(lt>0){
                // planeLauncher.setPosition(0.5);
            }
            else if(rt>0){
                // planeLauncher.setPosition(0);
            }
            else if (x){
              // planeLauncher.setPower(.75);
            }
            else{
                setPower(0,0,0,0);
               // lift.setPower(0);
                //arm.setPower(0);
                //planeLauncher.setPower(0);
            }
        }


    }
    public void setPower(double v1,double v2,double v3,double v4){
         rightBack.setPower(v1);
        rightFront.setPower(v2);
        leftBack.setPower(v3);
        leftFront.setPower(v4);
    }
}
