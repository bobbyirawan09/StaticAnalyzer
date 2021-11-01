package com.bobby.customrules

import io.gitlab.arturbosch.detekt.api.*
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction

/**
 * @author bobby
 * Created 31/10/21 at 15.51
 */
class RestrictionUsingBang(config: Config = Config.empty): Rule(config) {
    override val issue: Issue
        get() = Issue(
            javaClass.simpleName,
            Severity.CodeSmell,
            "Don't use !! unless you sure it won't contain null",
            Debt.FIVE_MINS
        )

    override fun visitNamedFunction(function: KtNamedFunction) {
        super.visitNamedFunction(function)
        if (function.bodyBlockExpression?.chars?.contains("!!") == true) {
            report(CodeSmell(issue, Entity.Companion.from(function),"Using !! could cause NPE"))
        }
    }
}