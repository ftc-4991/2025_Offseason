package org.firstinspires.ftc.teamcode.utility.chassis;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * This program is made to be able to simplify the creation/management of a
 * two wheel chassis.
 * left joystick controls the left motor
 * right controls the right motor
 */
public class Chassis {

    //Set the instance variables so they can be used later in the program
    Gamepad gamepad;
    Telemetry telemetry;
    DcMotor  left;
    DcMotor right;
    //Set other variables that may be used in methods later in the program
    boolean showTelemetry = false;
    /**
     * constructor to 'connect' the gamepad, telemetry, and motors you want to use
     *
     * @param g1 (the gamepad you want to use)
     * @param t1 (allows addition of telemetry data)
     * @param m1 (connects the first DcMotor --  left)
     * @param m2 (connects the second DcMotor -- right)
     */
    public Chassis(Gamepad g1, Telemetry t1, DcMotor m1, DcMotor m2) {
        //sets the instance variables so the correct variables reference the right objects
        gamepad = g1;
        telemetry = t1;
        left = m1;
        right = m2;

    }


    /**
     * checks the values of the left and right joystick, and sets the motor values to
     * what they are given
     */
    public void setMotorPower() {
        left.setPower(getMotorValues("left"));
        right.setPower(getMotorValues("right"));
    }




    /**
     * Sets the "showTelemetry variable to true. Needed for the getTelemetry method.
     */
    public void setShowTelemetry() {
        showTelemetry = true;
    }

    /**
     * if "showTelemetry" is true, when the code is run, the program will get all
     * relevant telemetry and print it to the driver station
     */
    public void getTelemetry() {
        if (showTelemetry) {
        //TODO add more stuff into here
        }
    }

    /**
     * finds the controller value of an inputted string and returns it as a double
     *
     * @param mN must be a String that's either "left" or "right"
     * @return
     */
    private double getMotorValues(String mN) {
        String motorName = mN.toLowerCase();
        double motorVal;
        if (motorName.equals("left")) {
            motorVal = gamepad.left_stick_y;
            return motorVal;
        } else if (motorName.equals("right")) {
            motorVal = gamepad.right_stick_y;
            return motorVal;
        }
        motorVal = -1;
        telemetry.addData("Invalid input recieved: ", motorVal);
       motorVal = 0;
       return motorVal;
    }








}
