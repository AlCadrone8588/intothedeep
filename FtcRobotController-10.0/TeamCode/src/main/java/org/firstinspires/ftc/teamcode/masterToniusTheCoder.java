package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Master Tonius the Coder", group = "Robot")
public class masterToniusTheCoder extends LinearOpMode {

    /* Declare OpMode members. */
    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;
    Servo theMedic;
    Servo theDozer;
    Servo theTazer;
    Servo bradyHeringtonIsShort;


    @Override
    // Set motor dire
    public void runOpMode() {
        leftFront = hardwareMap.dcMotor.get("lf");
        leftBack = hardwareMap.dcMotor.get("lb");
        rightBack = hardwareMap.dcMotor.get("rb");
        rightFront = hardwareMap.dcMotor.get("rf");
        theMedic = hardwareMap.servo.get("medic");
        theDozer = hardwareMap.servo.get("dozer");
        theTazer = hardwareMap.servo.get("tazer");
        bradyHeringtonIsShort = hardwareMap.servo.get("pickleballnerd");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        waitForStart();
        while (opModeIsActive()) {
            double rystick = gamepad1.right_stick_y;
            double rxstick = (gamepad1.right_stick_x) / 2.0;
            double lystick = (gamepad1.left_stick_y) / 2.0;
            double lxstick = (gamepad1.left_stick_x);
            boolean a = gamepad2.a;
            boolean b = gamepad2.b;
            boolean x = gamepad2.x;
            boolean y = gamepad2.y;
            boolean dpadup = gamepad2.dpad_up;
            boolean dpaddown = gamepad2.dpad_down;
            boolean dpadleft = gamepad2.dpad_left;
            boolean dpadright = gamepad2.dpad_right;

            boolean lb = gamepad2.left_bumper;
            boolean rb = gamepad2.right_bumper;

            if (Math.abs(lxstick) > 0 || Math.abs(lystick) > 0 || Math.abs(rxstick) > 0) {
                double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
                double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
                double rightX = -gamepad1.right_stick_x;

                double v1 = r * Math.sin(robotAngle) - rightX;
                double v2 = r * Math.cos(robotAngle) - rightX;
                double v3 = r * Math.cos(robotAngle) + rightX;
                double v4 = r * Math.sin(robotAngle) + rightX;


                // Use gamepad left & right Bumpers to open and close the claw
            }
                if (lb) {
                    bradyHeringtonIsShort.setPosition(1);
                }
                else if (rb) {
                    bradyHeringtonIsShort.setPosition(-1);
                }
                // Move both servos to new position


                // Use gamepad buttons to move Servos clockwise (arrows) and counterclockwise (YXBA)
                // left and X
                if (dpadleft) {
                    theMedic.setPosition(1);
                }
                else if (x) {
                    theMedic.setPosition(-1);
                }
                //up and Y
                if (dpadup) {
                    theDozer.setPosition(1);
                }
                else if (y) {
                    theDozer.setPosition(-1);
                }
                //right and B
                if (dpadright) {
                    theTazer.setPosition(1);
                }
                else if (b) {
                    theTazer.setPosition(-1);
                }
                // Send telemetry message to signify robot running;
                telemetry.addData("musicnerd", "Offset = %.2f", bradyHeringtonIsShort);
                telemetry.update();

                // Pace this loop so jaw action is reasonable speed.
                sleep(50);

            }
        }
    }

