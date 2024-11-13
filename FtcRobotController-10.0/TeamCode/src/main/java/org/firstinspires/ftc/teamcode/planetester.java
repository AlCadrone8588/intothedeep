package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp
public class planetester extends LinearOpMode {

    Servo planeLauncher;
    Servo autoArm;

    @Override
    public void runOpMode() {
        planeLauncher = hardwareMap.get(Servo.class, "planeLauncher");
        autoArm = hardwareMap.get(Servo.class,"autoArm");



        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                planeLauncher.setPosition(.5);



            }
            else if(gamepad1.b){
                planeLauncher.setPosition(0);

            }
            else if(gamepad1.x){
                autoArm.setPosition(0);
            } else if (gamepad1.y) {
                autoArm.setPosition(1);

            }
        }
    }
}