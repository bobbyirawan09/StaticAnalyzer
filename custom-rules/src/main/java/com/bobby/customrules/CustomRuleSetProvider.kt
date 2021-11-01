package com.bobby.customrules

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider

/**
 * @author bobby
 * Created 31/10/21 at 15.50
 */
class CustomRuleSetProvider: RuleSetProvider {
    override val ruleSetId: String
        get() = "custom-rules"

    override fun instance(config: Config): RuleSet {
        return RuleSet(ruleSetId, listOf(RestrictionUsingBang(config)))
    }
}