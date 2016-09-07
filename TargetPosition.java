package com.coolgame.silkroad.server.fight;

/**
 * 目标坐标
 * @author orange
 * 2015年3月31日
 */
public class TargetPosition {
	
	private short x;
	
	private short y;

	public TargetPosition(short x, short y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public TargetPosition(int x, int y) {
		super();
		this.x = (short)x;
		this.y = (short)y;
	}

	public TargetPosition add(TargetPosition tp){
		this.x += tp.x;
		this.y += tp.y;
		return this;
	}
	
	public short getX() {
		return x;
	}

	public short getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TargetPosition other = (TargetPosition) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TargetPosition [x=" + x + ", y=" + y + "]";
	}

	public void setX(short x) {
		this.x = x;
	}
	
	public void setY(short y) {
		this.y = y;
	}

}
