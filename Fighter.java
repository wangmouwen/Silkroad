package com.coolgame.silkroad.server.fight;

import java.util.Collection;
import java.util.List;

import com.coolgame.silkroad.server.fight.constants.Direction;
import com.coolgame.silkroad.server.fight.constants.ExStatusType;
import com.coolgame.silkroad.server.fight.constants.FightSchemaType;
import com.coolgame.silkroad.server.fight.constants.MoveMode;
import com.coolgame.silkroad.server.fight.constants.PetType;
import com.coolgame.silkroad.server.fight.constants.PoisonType;
import com.coolgame.silkroad.server.fight.exception.RoleFightException;
import com.coolgame.silkroad.server.fight.exstatus.ExStatus;
import com.coolgame.silkroad.server.fight.pk.PkStatusPool;
import com.coolgame.silkroad.server.fight.skill.Buff;
import com.coolgame.silkroad.server.fight.skill.FightEffect;

/**
 * 战斗参与者
 * 
 * @author jiangqi02
 * 
 */
public interface Fighter {

	String getInstanceId();

	long getId();

	/**
	 * 是否怪物
	 * 
	 * @return
	 */
	boolean isMonster();

	/**
	 * 是否是玩家
	 * 
	 * @return
	 */
	boolean isPlayer();

	/**
	 * 是否是召唤物
	 * 
	 * @return
	 */
	boolean isPet();

	/**
	 * 是否是NPC
	 * 
	 * @return
	 */
	boolean isFunctionNPC();

	/**
	 * 是否是侍卫
	 * 
	 * @return
	 */
	boolean isHousecarl();
	
	/**
	 * 是否是木桩(只能被怪物攻击，玩家无法攻击)
	 * @return
	 */
	boolean isWood();

	/**
	 * 是否是采集物
	 * @return
	 */
	boolean isCollectProp();
	

	/**
	 * 是否是红名的恶人
	 * 
	 * @return
	 */
	boolean isVillain();

	/**
	 * 等级
	 * 
	 * @return
	 */
	int getLevel();

	/**
	 * 生命值
	 * 
	 * @return
	 */
	int getHp();

	/**
	 * 最大生命值
	 * 
	 * @return
	 */
	int getHpCapacity();

	/**
	 * 获得力量
	 * 
	 * @return
	 */
	int getStrength();

	/**
	 * 获得体质
	 * 
	 * @return
	 */
	int getCorporeity();

	/**
	 * 获得敏捷
	 * 
	 * @return
	 */
	int getAgile();

	/**
	 * 获得智力
	 * 
	 * @return
	 */
	int getWit();

	/**
	 * 获得攻击
	 * 
	 * @return
	 */
	int getAttack();

	/**
	 * 获得防御
	 * 
	 * @return
	 */
	int getDefend();

	/**
	 * 获得精准值
	 * 
	 * @return
	 */
	int getAccurate();

	/**
	 * 获得精准率
	 * 
	 * @return
	 */
	double getAccurateRate();

	/**
	 * 获得闪避
	 * 
	 * @return
	 */
	int getDodge();

	/**
	 * 获得闪避率
	 * 
	 * @return
	 */
	double getDodgeRate();

	/**
	 * 获得暴击值
	 * 
	 * @return
	 */
	int getCritical();

	/**
	 * 获得暴击率
	 * 
	 * @return
	 */
	double getCriticalRate();

	/**
	 * 获得暴击伤害
	 * 
	 * @return
	 */
	double getCriticalDamage();

	/**
	 * 获得暴击率抵抗
	 * 
	 * @return
	 */
	double getCriticalRateResist();

	/**
	 * 获得暴击伤害抵抗
	 * 
	 * @return
	 */
	double getCriticalDamageResist();

	/**
	 * 获得韧性
	 * 
	 * @return
	 */
	int getTenacity();

	/**
	 * 获得pvp韧性
	 * 
	 * @return
	 */
	double getPvpTenacity();

	/**
	 * 获得pvp强度
	 * 
	 * @return
	 */
	double getPvpIntensity();

	/**
	 * 移动速度
	 * 
	 * @return
	 */
	short getMoveSpeed();

	/**
	 * 攻击速度
	 * 
	 * @return
	 */
	short getAttackSpeed();

	/**
	 * 物品掉落率
	 * @return
	 */
	public double getPropDropRate();

	/**
	 * 当前位置X坐标
	 * 
	 * @return
	 */
	short getX();

	/**
	 * 当前位置Y坐标
	 * 
	 * @return
	 */
	short getY();

	/**
	 * 更改当前坐标
	 * 
	 * @param x
	 * @param y
	 */
	void setPosition(short x, short y);

	/**
	 * 获得面向的方向
	 * 
	 * @return
	 */
	Direction getDirection();

	/**
	 * 改变面向的方向
	 * 
	 * @param direction
	 */
	void changeDirection(Direction direction);

	/**
	 * 所在的战斗区域
	 * 
	 * @return
	 */
	FightableRegion getFightableRegion();

	
	/**
	 * 获取角色当前所在的地图类型
	 */
	public byte getFighterMapType();
	
	
	/**
	 * 回复Hp
	 * 
	 * @param total
	 * @param onceValue
	 * @param duration
	 */
	void recoverHp(int total, int onceValue, int duration);

	/**
	 * 使用持续恢复药水
	 * @param total
	 * @param onceValue
	 * @param duration
	 * @param recoverTime
	 */
	void useDrug(int restoreAllValue, int onceRecoverValue, int recoverCount, int period);

	/**
	 * 添回异常状态
	 * 
	 * @param exStatus
	 */
	void addExStatus(ExStatus exStatus);

	/**
	 * 获得当前所拥有的状态
	 * 
	 * @return
	 */
	Collection<ExStatusType> getCurrStatus();

	/**
	 * 出招
	 * 
	 * @param trick
	 */
	void doTrick(long targetId, byte face, byte times, short sx, short sy, short dx, short dy, short idx) throws RoleFightException;

	/**
	 * 出招(风火轮爆炸时虚拟出招)
	 */
	void doTrick(Trick trick) throws RoleFightException;

	/**
	 * 接招
	 * 
	 * @param fightEffect
	 */
	void acceptTrick(FightEffect fightEffect) throws RoleFightException;

	/**
	 * 是否定身：角色无法通过非技能产生的移动而移动
	 * 
	 * @return
	 */
	boolean isFix();

	/**
	 * 定身
	 */
	void fix();

	/**
	 * 是否眩晕：角色无法通过非技能产生的移动而移动，且无法攻击、及释放技能
	 * 
	 * @return
	 */
	boolean isVertigo();

	/**
	 * 解定身
	 */
	void unFix();

	/**
	 * 眩晕
	 */
	void vertigo();

	/**
	 * 解眩晕
	 */
	void unVertigo();

	/**
	 * 召唤
	 */
	boolean summon(PetType type, int maxAccount, int systemRoleId, int level, short x, short y);

	/**
	 * 召唤
	 */
	boolean summon(PetType type, int maxAccount, Fighter monster);

	/**
	 * 获得主人（召唤物）
	 */
	Fighter getOwner();

	/**
	 * 跳到某点
	 * 
	 * @param position
	 */
	boolean jumpTo(short x, short y);

	/**
	 * 触发者通知跳跃
	 * 
	 * @param source
	 * @param others
	 * @param mode
	 */
	void notifyJumpTo(List<Fighter> jumpers, MoveMode mode);
	
	/**
	 * 通知移除PK池中的某个（过时）防御者
	 * @param defenderId 防御者ID
	 */
	void notifyRemovePkDefender(long defenderId);

	/**
	 * 移除异常状态
	 * 
	 * @param type
	 */
	void removeExStatus(ExStatusType type);

	/**
	 * 移除buff
	 * @param type
	 */
	void removeBuff(ExStatusType type);
	
	/**
	 * @Jack
	 * @Doc 是否是组队好友？
	 * @param role
	 * @return boolean
	 */
	boolean isFriend(Fighter role);

	/**
	 * 是否友军
	 * 
	 * @param role
	 * @return
	 */
	boolean isFriend(Fighter role, boolean harmful);

	/**
	 * 杀了其他角色
	 * 
	 * @param other
	 */
	void killOther(Fighter other, boolean harmful);

	/**
	 * 通知属性变化
	 * 
	 * @param aptitudeChanged
	 */
	void notifyPropertiesChanged(boolean aptitudeChanged, boolean selfOnly);

	/**
	 * 是否在线
	 * 
	 * @return
	 */
	boolean isOnline();

	/**
	 * 得到最后一次攻击自己的对象
	 * 
	 * @return
	 * @author yuanmingxu@hotmail.com
	 */
	Fighter getLastAttacker();

	/**
	 * 得到最后一次攻击目标
	 * 
	 * @return
	 */
	Fighter getLastTarget();

	/**
	 * 是否死亡了
	 */
	boolean isDead();
	
	/**
	 * 是否大刀兵
	 * @return
	 */
	boolean isDadao();

	/**
	 * 死亡掉落物品
	 */
	void dropProp(Fighter winner);

	/**
	 * 供给经验
	 */
	int supplyExperience(Fighter winner);

	/**
	 * 死亡后准备复活
	 */
	void prepareRevive();

	/**
	 * 得到主属性dc,mc或sc
	 */
	int getMainProperty();

	/**
	 * 施放释毒术 选择毒药
	 * 
	 * @return true: 灰粉伤害 false : 黄粉掉血
	 */
	PoisonType selectPoison();

	/**
	 * 是否隐身
	 */
	boolean isInvisible();

	long getTeamId();

	void acceptTrophy(int experience, String source);

	boolean hasExStatus(ExStatusType type);

	/**
	 * 是否存于安全保护状态
	 * 
	 * @return
	 */
	boolean isSafeStatus();

	void sendSysMsg(String msg);

	String getName();

	boolean canSummoned();

	boolean cousumePropOnce(String[] props);

	boolean pkOpened();

	boolean inMonsterCampaign();
	

	/**
	 * 是否同步位置
	 * @return
	 */
	public boolean isSyncPosition();

	/**
	 * 设置是否同步位置
	 * @param syncPosition 是否同步位置
	 */
	public void setSyncPosition(boolean syncPosition);

	/**
	 * 读取PK等级
	 * @return
	 */
	public byte getPkLevel();

	/**
	 * 读取战斗模式类型
	 * @return
	 */
	public FightSchemaType getFightSchemaType();

	/**
	 * 是否同公会
	 * @param other	他人
	 * @return
	 */
	public boolean isGuild(Fighter other);

	/**
	 * 是否同队伍
	 * @param other	他人
	 * @return
	 */
	public boolean isMember(Fighter other);

	/**
	 * 是否同阵营
	 * @param other	他人
	 * @return
	 */
	public boolean isCamp(Fighter other);

	/**
	 * 读取PK状态池
	 * @return
	 */
	public PkStatusPool getPkStatusPool();

	/**
	 * @Jack 安全区域的判断
	 * @Doc 安全区域不能进行 PK（目前定义为主城，仅对player类有效，monster,pet类是没有效果的）
	 * @return
	 */
	public boolean isSafeZone();

	/**
	 * 根据buffid添加buff并制定时长
	 * @param source
	 * @param buffId
	 * @param duration
	 */
	public void addBuff(Fighter source , int buffId , int duration);
	
	/**
	 * 根据buffid添加buff
	 * @param source 来源者
	 * @param buffId
	 */
	public void addBuff(Fighter source, int buffId);
	
	/**
	 * 给角色添加buff
	 * @param source 来源者
	 * @param buff
	 */
	public void addBuff(Fighter source , Buff buff);
	
	/**
	 * 移除身上buff
	 * @param buffId
	 */
	public void removeBuff(int buffId);
	
	/**
	 * 军团是否宣战中
	 * @param other	他人
	 * @return
	 */
	public boolean isGuildInWar(Fighter other);
	
	/**
	 * 减伤值
	 * @return
	 */
	int getDamageReduce();
	
	/**
	 * 减伤值%
	 * @return
	 */
	double getDamageReduceRate();
	
	/**
	 * 增加技能伤害值%
	 */
	double getSkillDamageRate();
}
