package com.abhi.martianrobot;

import com.abhi.martianrobot.instructions.Instruction;
import com.abhi.martianrobot.instructions.InstructionsRegister;

import java.util.LinkedList;
import java.util.List;

public class InputReader {

    private InstructionsRegister instructionsRegister;

    public InputReader(){
        this.instructionsRegister = new InstructionsRegister();
    }

    public InstructionsRegister getInstructionsRegister() {
        return instructionsRegister;
    }

    public List<Instruction> parseInstructions(String arg) {
        try {
            List<Instruction> instructions = new LinkedList<Instruction>();
            for (String c : arg.split("")) {
                Instruction instruction = instructionsRegister.getInstruction(c);
                if (instruction != null) {
                    instructions.add(instruction);
                } else {
                    throw new RuntimeException("Invalid instruction:" + c);
                }

            }
            return instructions;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public GridPoint parseGridPoint(String arg) {
        if (arg == null || arg.isEmpty()) {
            throw new RuntimeException("Invalid GridBound specified");
        }
        String[] input = arg.split(",");
        if (input.length == 2) {
            int xCoordinate = Integer.parseInt(input[0]);
            int yCoordinate = Integer.parseInt(input[1]);
            if(xCoordinate>50 || yCoordinate>50 || xCoordinate<1 || yCoordinate<1){
                throw new RuntimeException("Invalid GridBound specified"+xCoordinate+","+yCoordinate);
            }
            return new GridPoint(xCoordinate, yCoordinate);
        } else {
            throw new RuntimeException("Invalid GridBound specified");
        }
    }

    public RobotState parseRobotState(String arg) {
        try {
            if (arg == null || arg.isEmpty()) {
                throw new RuntimeException("Invalid GridBound specified");
            }
            String[] input = arg.split(",");
            if (input.length == 3) {
                int xCoordinate = Integer.parseInt(input[0]);
                int yCoordinate = Integer.parseInt(input[1]);
                GridPoint gridPoint = new GridPoint(xCoordinate, yCoordinate);
                Orientation orientation = Orientation.valueOf(input[2]);
                return new RobotState(gridPoint, orientation);
            } else {
                throw new RuntimeException("Invalid RobotState specified");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
