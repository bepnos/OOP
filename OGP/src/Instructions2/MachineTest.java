package Instructions2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class Instruction {
	abstract void execute(Machine machine); // ovewritten method
}

class LoadConstant extends Instruction{
	int r;
	int c; 
	LoadConstant(int r, int c){
		this.r = r;
		this.c = c; 
	}
	void execute(Machine machine) { // overwriting method
		machine.registers[r] = c;
		machine.pc++;
	}
}

class Decrement extends Instruction{
	int r;
	Decrement(int r){
		this.r = r;
	}
	void execute(Machine machine) {
		machine.registers[r]--;
		machine.pc++;
	}
}

class Multiply extends Instruction{
	int r1;
	int r2;
	Multiply(int r1, int r2){
		this.r1 = r1;
		this.r2 = r2;
	}
	void execute(Machine machine) {
		machine.registers[r1] = machine.registers[r1] * machine.registers[r2];
		machine.pc++;
	}
}

class JumpIfZero extends Instruction{
	int r;
	int a;
	JumpIfZero(int r, int a){
		this.r = r;
		this.a = a;
	}
	void execute(Machine machine) {
		if (machine.registers[r] == 0)
			machine.pc = a;
		else
			machine.pc++;
	}
}

class Jump extends Instruction{
	private int a;
	int a() {return a;}
	Jump(int a){
		this.a = a;
	}
	void execute(Machine machine) {
		machine.pc = a;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Jump j && a == j.a;
		}
	
	@Override // Hashcode method ook overschrijven
	public int hashCode() {
		return a;
	}
	
	@Override // changes error message string for jump objects
	public String toString() {
		return "Jump (" + a + ")";
	}
}
// anagolous to the Jump method in terms of overrides however records cant inherit and thus cant be used here
record JumpRecord(int a) {}

class Halt extends Instruction{
	void execute(Machine machine) {
		machine.pc = -1;
	}
}

class Machine {
	int pc;
	int[] registers;
	void execute(int[] registers, Instruction[] instructions) {
		this.registers = registers;
		pc = 0;
		while(0 <= pc) {
			Instruction i = instructions[pc];
			i.execute(this); // dynamic binding
		}
	}

}

class MachineTest {
	@Test
	void test() {
		assertEquals(new Jump(2), new Jump(2)); // because we changed equals method
		// assertEquals(new Jump(3), new Jump(2)); 
		assertEquals(4, power(2, 2));
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


