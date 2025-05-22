package org.firstinspires.ftc.teamcode.utility.chassis;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * This program is made to be able to simplify the creation/management of a
 * two wheel chassis. telemetry is optional and is defaulted off.Chassis speed
 * can be changed and is defaulted to 100% power (1.0)
 * left joystick controls the left motor
 * right joystick controls the right motor
 */
public class Chassis {

    //Set the instance variables so they can be used later in the program
    Gamepad gamepad;
    Telemetry telemetry;
    DcMotor  left;
    DcMotor right;
    //Set other variables that may be used in methods later in the program
    boolean showTelemetry = false;
    double motorVal;
    double cSpeed;
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
     * Alternative constructor for a Chassis object that will leave out  the telemetry
     * in case it is not being used
     * @param g1 a gamepad variable
     * @param m1 the left wheel variable
     * @param m2 the right wheel variable
     */
    public Chassis(Gamepad g1, DcMotor m1, DcMotor m2) {
        gamepad = g1;
        left = m1;
        right =m2;
    }


    /**
     * checks the values of the left and right joystick, and sets the motor values to
     * what they are given
     */
    public void setMotorPower() {
        left.setPower(getMotorValues("left") * cSpeed);
        right.setPower(getMotorValues("right") * cSpeed);
    }

    /**
     * Sets the "showTelemetry variable to true. Needed for the getTelemetry method.
     */
    public void setShowTelemetry() {
        showTelemetry = true;
    }

    /**
     * if "showTelemetry" is true, when the code is run, the program will get all
     * relevant telemetry and print it to the driver station, otherwise it does nothing
     * Method will automatically update telemetry in the method SUBJECT TO CHANGE
     *
     */
    public void getTelemetry() {
        if (showTelemetry) {
        telemetry.addData("Left Motor Pos: ", left);
        telemetry.addData("Right Motor Pos: ", right);
        telemetry.addData("Motor Power is at: ", motorVal);
        telemetry.update();
        }
    }
    /**
     * Sets the value of the value (and maximum) of the chassis speed
     * newSpeed should be between -1 to 0 to 1 (90% should be 0.9)
     * @param newSpeed the maximum amount of power you want the motor to run at
     */
    public void setCSpeed(double newSpeed) {
        cSpeed = newSpeed;
    }
    /**
     * finds the controller value based on an inputted string and returns it as a double
     *
     * @param mN must be a String that's either "left" or "right"
     */
    private double getMotorValues(String mN) {
        String motorName = mN.toLowerCase();
        if (motorName.equals("left")) {
            motorVal = gamepad.left_stick_y;
            return motorVal;
        } else if (motorName.equals("right")) {
            motorVal = gamepad.right_stick_y;
            return motorVal;
        }
        motorVal = -1;
        telemetry.addData("Invalid input received: ", motorVal);
       motorVal = 0;
       return motorVal;
    }








}
