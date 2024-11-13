package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@TeleOp(name = "S&P approved")
public class penis extends LinearOpMode {

    DcMotor leftHole;
    DcMotor rightHole;
    DcMotor leftAss;
    DcMotor rightAss;
  //  DcMotor elevator;

    //Servo leftFish;
    //Servo rightFish;

    @Override
    public void runOpMode(){

        leftHole = hardwareMap.dcMotor.get("lh");
        rightHole = hardwareMap.dcMotor.get("rh");
        leftAss = hardwareMap.dcMotor.get("la");
        rightAss = hardwareMap.dcMotor.get("ra");

      //  elevator = hardwareMap.dcMotor.get("e");

       // leftFish = hardwareMap.servo.get("lf");
      //  rightFish = hardwareMap.servo.get("rf");



        waitForStart();
        while (opModeIsActive()) {

            double front = gamepad1.right_stick_y;
            double strafe = gamepad1.right_stick_x;
            double shpeen = gamepad1.left_stick_y;
            double davidsWillToLive = gamepad2.right_trigger;
            double matthewsGiantCock = gamepad2.left_trigger;

            leftHole.setPower(-front + strafe - shpeen);
            leftAss.setPower(-front - strafe - shpeen);
            rightHole.setPower(-front - strafe + shpeen);
            rightAss.setPower((-front + strafe + shpeen));

        //    elevator.setPower(davidsWillToLive-matthewsGiantCock);

            if (gamepad2.a){
           //     leftFish.setPosition(0);
             //   rightFish.setPosition(0.05);
            }
            if (gamepad2.b){
             //   leftFish.setPosition(0.05);
              //  rightFish.setPosition(0);
            }

        }stop();
    }

}