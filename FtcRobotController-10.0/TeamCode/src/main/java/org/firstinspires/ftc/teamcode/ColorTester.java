package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
@TeleOp
public class ColorTester extends LinearOpMode {

        ColorSensor centerColor;
        @Override
        public void runOpMode() {
            centerColor = hardwareMap.get(ColorSensor.class, "centerColor");

            waitForStart();
            while (opModeIsActive()) {
                if(gamepad1.a) {
                    telemetry.addData("Red", centerColor.red());
                    telemetry.addData("Green", centerColor.green());
                    telemetry.addData("Blue", centerColor.blue());
                    telemetry.addData("Alpha", centerColor.alpha());
                    telemetry.addData("Hue", centerColor.argb());

                    telemetry.addData("Blue scaled", centerColor.blue()/(double)centerColor.alpha());
                    telemetry.addData("Green scaled", centerColor.green()/(double)centerColor.alpha());
                    telemetry.addData("Red scaled", centerColor.red()/(double)centerColor.alpha());
                    telemetry.update();
                }
            }
        }

}

