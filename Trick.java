package com.coolgame.silkroad.server.fight;

import java.util.ArrayList;
import java.util.List;

import com.coolgame.silkroad.server.fight.exception.RoleFightException;
import com.coolgame.silkroad.server.fight.skill.FightEffect;
import com.coolgame.silkroad.server.fight.skill.Skill;

public class Trick {
	
	/** 发招者 */
	private Fighter source;
	
	/** 目标*/
	private Fighter target;
	/** 所用技能 */
	private Skill skill;
	
	private byte times;
	//发招者的X坐标
	private short x;
	//发招者的Y坐标
	private short y;
	
	private long targetID;

	/** 技能发出的效果 */
	private FightEffect outputEffect;
	
	/** 技能输出目标 */
	private List<Fighter> outputTargets=new ArrayList<Fighter>();
	
	/** 技能影响到的目标数目 */
	private byte affectRoleNum;
	
	/** 是否需要播放效果 */
	private boolean needPlayEffect = true;
	
	public Trick(Fighter source, Skill skill) {
		this.source = source;
		this.skill = skill;
	}
	
	public void output(Fighter target) throws RoleFightException {
		if(outputEffect == null) {
			return;
		}
		if (affectRoleNum >= skill.getSkillEffect().getAffectRoleNum()) {
			return;
		}
		if (skill.getOutputFilter().output(target, outputEffect)) {
			affectRoleNum ++;
		}
	}
	
	public FightEffect createOutputEffect(boolean harmful) throws RoleFightException {
		if (outputEffect == null) {
			outputEffect = new FightEffect(skill.getSkillType(), source, harmful);
			// 增加buffer
			skill.getSkillEffect().takeAutoEffect(this);
		}
		return outputEffect;
	}

	public List<Fighter> getOutputTargets() {
		return outputTargets;
	}
	
	public void addOutputTarget(Fighter outputTarget) {
		if (outputTarget == null) {
			return;
		}
		
//		if(this.outputTargets == null) {
//			this.outputTargets =new ArrayList<Fighter>() ;
//		}
		
		if (!outputTargets.contains(outputTarget)) {
			outputTargets.add(outputTarget);
		}

		if (source.isPlayer() && outputTarget.isPlayer()) {
			// 添加防御者
			source.getPkStatusPool().addDefender(outputTarget);
		}
	}
	
	public FightEffect getOutputEffect() {
		return outputEffect;
	}

	public Fighter getSource() {
		return source;
	}
	
	public Fighter getTarget() {
		return target;
	}

	public void setTarget(Fighter val) {
		target=val ;
	}
	public Skill getSkill() {
		return skill;
	}

	public short getX() {
		return x;
	}

	public short getY() {
		return y;
	}

	public void setPosition(short x, short y) {
		this.x = x;
		this.y = y;
	}

	public long getTargetID() {
		return targetID;
	}

	public void setTargetID(long target) {
		this.targetID = target;
	}

	public boolean isCrit() {
		if(outputEffect == null) {
			return false;
		}
		return outputEffect.isCrit();
	}

	public boolean isNeedPlayEffect() {
		return needPlayEffect;
	}

	public void setNeedPlayEffect(boolean needPlayEffect) {
		this.needPlayEffect = needPlayEffect;
	}

	public byte getTimes() {
		return times;
	}

	public void setTimes(byte times) {
		this.times = times;
	}
	
}
