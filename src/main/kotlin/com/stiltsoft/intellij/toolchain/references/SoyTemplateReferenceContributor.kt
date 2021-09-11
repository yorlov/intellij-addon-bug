package com.stiltsoft.intellij.toolchain.references

import com.intellij.lang.javascript.psi.JSCallExpression
import com.intellij.lang.javascript.psi.JSReferenceExpression
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceContributor
import com.intellij.psi.PsiReferenceProvider
import com.intellij.psi.PsiReferenceRegistrar
import com.intellij.util.ProcessingContext
import com.stiltsoft.intellij.toolchain.psiElement

class SoyTemplateReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        val template = psiElement<JSReferenceExpression>().withParent(psiElement<JSCallExpression>())

        registrar.registerReferenceProvider(template, object : PsiReferenceProvider() {
            override fun getReferencesByElement(name: PsiElement, context: ProcessingContext) = arrayOf(SoyTemplateReference(name))
        })
    }
}