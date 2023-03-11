package Instructions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class Instruction {}

class LoadConstant extends Instruction{
	int r;
	int c; 
	LoadConstant(int r, int c){
		this.r = r;
		this.c = c; 
	}
}

class Decrement extends Instruction{
	int r;
	Decrement(int r){
		this.r = r;
	}
}

class Multiply extends Instruction{
	int r1;
	int r2;
	Multiply(int r1, int r2){
		this.r1 = r1;
		this.r2 = r2;
	}
}

class JumpIfZero extends Instruction{
	int r;
	int a;
	JumpIfZero(int r, int a){
		this.r = r;
		this.a = a;
	}
}

class Jump extends Instruction{
	int a;
	Jump(int a){
		this.a = a;
	}
}

class Halt extends Instruction{
	
}

class Machine {
	int pc;
	int[] registers;
	void execute(int[] registers, Instruction[] instructions) {
		pc = 0;
		this.registers = registers;
		while (0 <= pc) {
			Instruction i = instructions[pc];
			
			if (i instanceof LoadConstant lc) {
				registers[lc.r] = lc.c;
				pc++;
			}
			
			if (i instanceof Decrement dc) {
				registers[dc.r] = registers[dc.r] - 1;
				pc++;
			}
			
			if (i instanceof Multiply mp) {
				registers[mp.r1] = registers[mp.r1] * registers[mp.r2];
				pc++;
			}
			
			if (i instanceof JumpIfZero jz) {
				if (registers[jz.r] == 0) pc = jz.a;
			}
			
			if (i instanceof Jump jp) {
				pc = jp.a;
			}
			
			if (i instanceof Halt ht) {
				pc = -1;
			}
		}
	}

}

class MachineTest {
	@Test
	void test() {
		assertEquals(8, power(2, 2));
		assertEquals(9, power(3, 2));
	}
	int power(int x, int y) {
		Instruction[] powerProgram = {
				new LoadConstant(2, 1),
				new JumpIfZero(1, 5),
				new Multiply(2, 0),
				new Decrement(1),
				new Jump(1),
				new Halt()
		};
		int[] registers = {x, y, 0};
		new Machine().execute(registers, powerProgram);
		return registers[2];
	}
}


