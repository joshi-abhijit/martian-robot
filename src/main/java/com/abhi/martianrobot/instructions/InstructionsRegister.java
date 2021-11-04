package com.abhi.martianrobot.instructions;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class InstructionsRegister {
    Map<String, Instruction> instructionMap = new HashMap<>();
    public InstructionsRegister(){
        // this can be moved to Spring for DI
        // for simplicity it is kept here
        instructionMap.put("F",new ForwardInstruction());
        instructionMap.put("L",new LeftInstruction());
        instructionMap.put("R",new RightInstruction());
    }

    public Instruction getInstruction(String instructionCode){
        return instructionMap.get(instructionCode);
    }

    public String getInstructionsRegistered(){
        return instructionMap.keySet().stream().collect(Collectors.joining());
    }
}
