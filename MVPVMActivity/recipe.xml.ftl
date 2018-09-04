<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <#include "../common/recipe_manifest.xml.ftl" />
    <@kt.addAllKotlinDependencies />

<#if generateLayout>
    <merge from="root/AndroidManifest.xml.ftl"
           to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

    <instantiate from="root/res/Activity.xml.ftl"
             to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
</#if>

<#if generateKotlin>
    <instantiate from="root/src/app_package/SimpleActivity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${activityClass}.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/${activityClass}.kt" />
<#else>
    <instantiate from="root/src/app_package/SimpleActivity.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/view/${activityClass}.java" />
    <open file="${escapeXmlAttribute(srcOut)}/view/${activityClass}.java" />

    <#if generateViewModel>
        <instantiate from="root/src/app_package/SimpleViewModel.java.ftl"
                    to="${escapeXmlAttribute(srcOut)}/viewmodel/${viewModelClass}.java" />
        <open file="${escapeXmlAttribute(srcOut)}/viewmodel/${viewModelClass}.java" />
    </#if>

    <#if generateModel>
        <instantiate from="root/src/app_package/SimpleModel.java.ftl"
                     to="${escapeXmlAttribute(srcOut)}/model/${modelClass}.java" />
        <open file="${escapeXmlAttribute(srcOut)}/model/${modelClass}.java" />
    </#if>
</#if>

</recipe>
