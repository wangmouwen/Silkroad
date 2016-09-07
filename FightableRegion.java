package com.coolgame.silkroad.server.fight;

import java.util.List;

/**
 * 可战斗区
 * @author jiangqi02
 * 
 */
public interface FightableRegion {

	/**
	 * 地图ID
	 * @return
	 */
	String getId();

	/**
	 * 线路ID
	 * @return
	 */
	byte getChannel();

	/**
	 * 获取指定坐标的参战者
	 * @param x
	 * @param y
	 * @return
	 */
	List<Fighter> getFighter(short x, short y);

	/**
	 * 根据ID获得参战者
	 * @param id
	 * @return
	 */
	Fighter getFighter(long id);

	/**
	 * 坐标上是否是障碍物
	 * @param x
	 * @param y
	 * @return
	 * @author yuanmingxu@hotmail.com
	 */
	public boolean isBarrier(short x, short y);

	/**
	 * 坐标出界
	 * @param x
	 * @param y
	 * @return
	 * @author yuanmingxu@hotmail.com
	 */
	public boolean isOutOfMap(short x, short y);

	/**
	 * 尝试进入指定坐标，指定坐标不可进入时返回false
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean tryEnterTile(Fighter fighter, short x, short y);

	/**
	 * 指定坐标地块能否进入
	 * @param x
	 * @param Y
	 * @return
	 */
	public boolean canEnterTile(short x, short y);

	public boolean addtiles(Fighter fighter, short x, short y);
}
