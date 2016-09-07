package com.coolgame.silkroad.server.fight;

import com.coolgame.silkroad.server.fight.role.FightSyncRandomPool;


/**
 * 战斗相关服务
 * @author shenpeihui
 *
 */
public class FighterService {
	
	/**
	 * 单例
	 */
	private static final FighterService instance = new FighterService();

	/**
	 * 读取单例
	 * @return the instance
	 */
	public static final FighterService getInstance() {
		return instance;
	}
	
	/**
	 * 运行服务
	 */
	public void run() {
//		SyncRandomPool.getInstance();
	}
	
	/**
	 * 战斗者离开游戏世界
	 * @param fighterId
	 */
	public void leaveGameWorld(long fighterId) {
		FightSyncRandomPool.getInstance().removeSyncRandomPool(fighterId);
	}
	
}
