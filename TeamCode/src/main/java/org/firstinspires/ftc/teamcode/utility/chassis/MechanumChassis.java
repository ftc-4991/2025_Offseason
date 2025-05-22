package org.firstinspires.ftc.teamcode.utility.chassis;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * This program was made to be able to simplify the creation/management of a
 * mechanum chassis telemetry is optional and is defaulted off. Chassis speed
 * can be changed and is defaulted to 100% power (1.0)
 * The chassis is controlled by:
 * left-joystick up and down moves up and down
 * left-joystick left and right strafes left and right
 *
 */
public class MechanumChassis extends Chassis {

    //Instance variables to be used in the program
    /**
     * gamepad will allow the assignment/checking of buttons on the controller
     */
    Gamepad gamepad;
    /**
     * Telemetry allows to collect data from the robot
     */
    Telemetry telemetry;
    /**
     * the front right motor/wheel of the chassis
     */
    DcMotor fr;
    /**
     * the front left motor/wheel of the chassis
     */
    DcMotor fl;
    /**
     * the back right motor/wheel of the chassis
     */
    DcMotor br;
    /**
     * the back left motor/wheel of the chassis
     */
    DcMotor bl;
    /**
     * controls whether telemetry will be shown/added on the call to the getTelemetry method
     */
    boolean showTelemetry = false;
    double motorVal;
    /**
     * Determines the speed that the chassis will be able to run at
     */
    double cSpeed = 1;

    /**
     * Constructor that connects to the gamepad and telemetry, as well as all the wheels of the program.
     * All wheels should be powered when using this chassis
     * @param gp         the gamepad variable/controller that connects to the rest of it
     * @param tlmy       the telemetry variable that allows for updating positions of the motors
     * @param frontRight the front right wheel of the robot
     * @param frontLeft  the front left wheel of the robot
     * @param backRight  the back right wheel of the robot
     * @param backLeft   the back left wheel of the robot
     */
    public MechanumChassis (Gamepad gp, Telemetry tlmy, DcMotor frontRight, DcMotor frontLeft, DcMotor backRight, DcMotor backLeft) {
        super(gp,tlmy,backLeft,backRight);
        gamepad = gp;
        telemetry = tlmy;
        fr = frontRight;
        fl = frontLeft;
        br = backRight;
        bl = backLeft;

    }

    /**
     * Determines and sets the speed of the motor based on the joystick values
     * and the chassis speed
     */
    public void setMotorPower() {
        //sets the value of the joysticks to variables, the left-y, left-x, and right-x
        double y = getMotorValues("leftY") * cSpeed;
        double x = getMotorValues("leftX") * cSpeed;
        double rx = getMotorValues("rightX")* cSpeed;

        fr.setPower(y+x+rx);
        fl.setPower(y-x-rx);
        br.setPower(y-x+rx);
        bl.setPower(y+x-rx);

    }
    //TODO write a method that overloads the telemetry method to add the other variables needed

    /**
     * Sets the value of the value (and maximum) of the chassis speed
     * newSpeed should be between -1 to 0 to 1 (90% should be 0.9)
     * @param newSpeed the maximum amount of power you want the motor to run at
     */
    public void setCSpeed(double newSpeed) {
        cSpeed = newSpeed;
    }
    /**
     * Sets the showTelemetry variable to true on both this class and the parent class
     */
    public void setShowTelemetry() {
        showTelemetry = true;
        super.setShowTelemetry();
    }

    /**
     * This method will take the joystick and use it to return the value that direction holds
     * and return it
     * @param joystick the joystick you want to check and the direction its checking (x-axis or y-axis)
     * @return returns the value of the joystick as a double value
     */
    private double getMotorValues(String joystick) {

        switch (joystick) {
            case "leftY":
                motorVal = gamepad.left_stick_y;
                break;
            case "leftX":
                motorVal = gamepad.left_stick_x;
                break;
            case "rightX":
                motorVal = gamepad.right_stick_x;
                break;
        }
        return motorVal;
    }
}
