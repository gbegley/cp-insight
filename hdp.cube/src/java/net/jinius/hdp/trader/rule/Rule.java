package net.jinius.hdp.trader.rule;

import net.jinius.hdp.trader.Entity;
import net.jinius.hdp.trader.Trade;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 *
 *
 */
public class Rule {


    /**
     *
     */
    private final Integer precedence;


    /**
     *
     */
    private Set<Entity> conditions;


    /**
     *
     */
    private Set<Formula> consequences;


    /**
     *
     */
    public Rule(Integer precedence, Entity condition, Formula consequence) {
        this(
            precedence,
            new LinkedHashSet<Entity>(Arrays.asList(condition)),
            new LinkedHashSet<Formula>(Arrays.asList(consequence))
        );
    }


    /**
     *
     */
    public Rule(Integer precedence, Set<Entity> conditions, Set<Formula> consequences) {
        this.precedence = precedence;
        this.conditions = conditions;
        this.consequences = consequences;
    }


    /**
     *
     */
    public Rule() {
        this(0,new LinkedHashSet<Entity>(),new LinkedHashSet<Formula>());
    }

    public Set<Formula> getConsequences() {
        return consequences;
    }

    public Set<Entity> getConditions() {
        return conditions;
    }

    public Integer getPrecedence() {
        return precedence;
    }


    public boolean appliesTo(Trade s) {
        return false;
    }

}
