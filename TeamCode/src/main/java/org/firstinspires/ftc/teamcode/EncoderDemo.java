package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class EncoderDemo extends LinearOpMode {
    DcMotor motor = null;
    int Pos1 = 1125;
    int Pos2 = 0;



    public void runOpMode() {


       motor = hardwareMap.get(DcMotor.class,"motor");
       motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        telemetry.addData("motor position : ", motor.getCurrentPosition());
        telemetry.update();

        waitForStart();

        while(opModeIsActive()) {
            if(gamepad1.a) {
                sleep(250);
                motor.setTargetPosition(Pos1);
                motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motor.setPower(0.25);

            }
            if(gamepad1.b) {
                sleep(250);
                motor.setTargetPosition(Pos2);
                motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                motor.setPower(0.25);
            }
           // if(motor.getCurrentPosition() == 1125) {
                telemetry.addData("motor position : ", motor.getCurrentPosition());
            //}
            telemetry.update();
        }
    }




}
