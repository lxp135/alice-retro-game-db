# Alice RetroGame DB

<p>
  <a href="#公众号"><img src="https://img.shields.io/badge/%E5%85%AC%E4%BC%97%E5%8F%B7-%E7%AB%B9%E6%A0%8F%E5%91%93%E8%AF%AD-green.svg" alt="公众号"></a>
</p>

## 前言

> 这几年一直在玩开源掌机，接触了很多linux改的模拟器系统和很多人发布的资源整合包，各有优缺点，始终不能找到特别合心意的。
> 鉴于外国站点没有中文，国内的资料又不全，所以我准备自己整理收集资料并制作一个怀旧游戏数据库开放给国内玩家使用。

## 项目介绍

`alice-retro-game-db`是一个怀旧游戏机数据库，目前仅收录发售30年以上的机型及其游戏资料，游戏机种类包含街机、家用机、掌机等机型。

目前家用机计划收录Family Computer、Super Famicom、Mega Drive/Sega Genesis和PC Engine四款机型及其游戏，掌机计划收录Atari Lynx、GameGear和GameBoy/GameBoy Color四款机型及其游戏。

主机机型提供中/日/英文名称、图标、实机图、设计图、首发日期、厂商、配置、机型介绍等信息。

游戏提供编号、中/日/英文名称、首发日期、售价（含币种）、地区、游戏类型、游戏介绍、玩家数量、平台、厂商、展示图、插画、海报、包装盒图、卡带图、演示视频等信息。

提供强大的搜索功能：支持跨机型、跨地区搜索，支持中/日/英文名称模糊匹配，支持按游戏类型、地区、平台、厂商、语言筛选。

提供ROM下载功能，支持汉化与修改版ROM下载，同一游戏可同时存在不同汉化版或修改版。

提供游戏试玩功能，游戏可直接在页面运行，支持键盘（登录可自定义键位）和微软手柄操作。

支持登录用户提交文字订正，补充缺失或错漏的图片，管理员审批后生效。

支持导出Batocera Linux、Ark OS、Pegasus Frontend、JEL OS等模拟器系统的配置文件。

## 项目文档
    
## Structure

- alice-retro-game-db 工程名称，端口9091。

## DataBase

- MySQL 5.7

## BackEnd
- Java11
- SpringBoot 2.6.14
- SpringMVC 5.3.24
- Mybatis 2.2.2
- mysql-connector-j 8.0.31
- sa-token 1.34.0
- Fastjson2 2.0.23
- HuTool 5.8.11
- Lombok 1.18.24

## FrontEnd

- React 17.0.2
- Ant Design 5.1.5
- Ant Design icons 5.0.0
- dayJs 1.11.7
- babel-browser
- babel-require

## DevelopmentPlan

各位朋友如果有意见和建议，可以在本项目提交Issues，我会视情况纳入下一步的开发计划。

## 公众号

作者日常推送的技术&社评文章，关注公众号「**竹栏呓语**」第一时间获取。

加微信群交流，公众号后台回复「**加群**」即可。

![公众号图片](https://creator.liuxp.me/img/wechat.png)

## 许可证

Copyright (c) 2023 liuxp.me