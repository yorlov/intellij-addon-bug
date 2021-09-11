package com.stiltsoft.intellij.toolchain.references

import com.google.bamboo.soy.parser.SoyTemplateBlock
import com.google.bamboo.soy.stubs.index.TemplateBlockIndex
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementResolveResult
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.ResolveResult
import com.intellij.psi.search.ProjectScope

class SoyTemplateReference(call: PsiElement) : PsiReferenceBase.Poly<PsiElement>(call, true) {

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val project = element.project
        val templates = TemplateBlockIndex.INSTANCE.get(element.text, project, ProjectScope.getAllScope(project))
                .map(SoyTemplateBlock::getDefinitionIdentifier)
        return PsiElementResolveResult.createResults(templates)
    }

    override fun getVariants() = emptyArray<Any>()
}