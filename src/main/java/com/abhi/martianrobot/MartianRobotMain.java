package com.abhi.martianrobot;

import com.abhi.martianrobot.instructions.Instruction;
import com.abhi.martianrobot.instructions.InstructionsRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MartianRobotMain {

    private static Logger logger = LoggerFactory.getLogger(MartianRobotMain.class);
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter grid bounds in format x,y- ");
        String gridBoundInput= sc.nextLine();
        InputReader inputReader = new InputReader();
        GridPoint gridBound = inputReader.parseGridPoint(gridBoundInput);
        RobotStateMachine robotStateMachine = new RobotStateMachine(gridBound);
        System.out.print("Enter number of robots- ");
        int numRobots= sc.nextInt();
        for(int i=0;i<numRobots;i++){
            System.out.print("Enter robot["+i+"]"+ " state in format x,y,o:");
            RobotState robotState = inputReader.parseRobotState(sc.next());
            if(robotState==null){
                System.out.print("Enter robot["+i+"]"+ " state in format x,y,o:");
                robotState = inputReader.parseRobotState(sc.next());
            }
            System.out.print("Enter robot["+i+"]"+ " instructions in format "+ inputReader.getInstructionsRegister().getInstructionsRegistered()+" :");
            List<Instruction> instructions = inputReader.parseInstructions(sc.next());
            if(instructions==null){
                System.out.print("Enter robot["+i+"]"+ " instructions in format "+ inputReader.getInstructionsRegister().getInstructionsRegistered()+" :");
                instructions = inputReader.parseInstructions(sc.next());
            }
            robotStateMachine.execute(i,robotState,instructions);

        }
        System.out.println("OUTPUT");
        robotStateMachine.printState();

        /*
        if(args.length!=3){
            logger.error("Please supply right number of arguments"
                        +System.lineSeparator()
                        + "GridBounds as  x,y,N/S/E/W"
                        + "RobotState as  x,y,N/S/E/W"
                        + "Instructions as example LFER");
        }*/

    }

}
