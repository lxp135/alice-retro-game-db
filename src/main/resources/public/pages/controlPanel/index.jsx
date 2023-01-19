const {  Layout, Menu, Breadcrumb  } = antd;
const { SubMenu } = Menu;
const { Header, Content, Sider,Footer } = Layout;
const {MailOutlined,AppstoreOutlined,SettingOutlined,UserOutlined,LogoutOutlined} = icons;


const controlPanel = () => {

    let menuClick = function(key){
        // alert(1);
        console.log(key);
        window.location.href = "#key"+key.key
    }

    function getItem(label, key, icon, children, type) {
        return {
            key,
            icon,
            children,
            label,
            type,
        };
    }
    const items = [
        getItem('Navigation One', 'sub1', <MailOutlined />, [
            getItem('Item 1', 'g1', null, [getItem('Option 1', '1'), getItem('Option 2', '2')], 'group'),
            getItem('Item 2', 'g2', null, [getItem('Option 3', '3'), getItem('Option 4', '4')], 'group'),
        ]),
        getItem('Navigation Two', 'sub2', <AppstoreOutlined />, [
            getItem('Option 5', '5'),
            getItem('Option 6', '6'),
            getItem('Submenu', 'sub3', null, [getItem('Option 7', '7'), getItem('Option 8', '8')]),
        ]),
        getItem('Navigation Three', 'sub4', <SettingOutlined />, [
            getItem('Option 9', '9'),
            getItem('Option 10', '10'),
            getItem('Option 11', '11'),
            getItem('Option 12', '12'),
        ]),
        getItem('Group', 'grp', null, [getItem('Option 13', '13'), getItem('Option 14', '14')], 'group'),
    ];

    const menuItems = [
            {
                key: 'center',
                icon: <UserOutlined />,
                label: '个人中心',
            },
        {
            key: 'settings',
                icon: <SettingOutlined />,
                label: '个人设置',
            },
        {
            key: 'logout',
                icon: <LogoutOutlined />,
                label: '退出登录',
            },
    ];

    return (
        <Layout>
            <Header className="header">
                <div className="logo" />

            </Header>
            <Layout>
                <Sider width={200} className="site-layout-background">
                    <Menu
                        onClick={menuClick}
                        mode="inline"
                        defaultSelectedKeys={['1']}
                        defaultOpenKeys={['sub1']}
                        theme="dark"
                        style={{ height: '100%', borderRight: 0 }}
                        items={menuItems}
                    >
                        {/*<SubMenu key="sub1"  title="subnav 1">*/}
                        {/*    <Menu.Item key="1"><div className="fa fa-camera-retro fa-fw"/>option1</Menu.Item>*/}
                        {/*    <Menu.Item key="2"><i className="iconfont">&#xebe0;</i>option2</Menu.Item>*/}
                        {/*    <Menu.Item key="3">option3</Menu.Item>*/}
                        {/*    <Menu.Item key="4">option4</Menu.Item>*/}
                        {/*</SubMenu>*/}
                        {/*<SubMenu key="sub2"  title="subnav 2">*/}
                        {/*    <Menu.Item key="5">option5</Menu.Item>*/}
                        {/*    <Menu.Item key="6">option6</Menu.Item>*/}
                        {/*    <Menu.Item key="7">option7</Menu.Item>*/}
                        {/*    <Menu.Item key="8">option8</Menu.Item>*/}
                        {/*</SubMenu>*/}
                        {/*<SubMenu key="sub3"  title="subnav 3">*/}
                        {/*    <Menu.Item key="9">option9</Menu.Item>*/}
                        {/*    <Menu.Item key="10">option10</Menu.Item>*/}
                        {/*    <Menu.Item key="11">option11</Menu.Item>*/}
                        {/*    <Menu.Item key="12">option12</Menu.Item>*/}
                        {/*</SubMenu>*/}
                    </Menu>
                </Sider>

                <Layout style={{ padding: '0 24px 24px' }}>
                    <Breadcrumb style={{ margin: '16px 0' }}>
                        <Breadcrumb.Item>Home</Breadcrumb.Item>
                        <Breadcrumb.Item>List</Breadcrumb.Item>
                        <Breadcrumb.Item>App</Breadcrumb.Item>
                    </Breadcrumb>
                    <Content
                        className="site-layout-background"
                        style={{
                            padding: 24,
                            margin: 0,
                            minHeight: 280,
                        }}
                    >
                        <div
                            className="site-layout-background"
                            style={{
                                padding: 24,
                                minHeight: 360,
                            }}
                        >
                            Bill is a cat.
                        </div>
                    </Content>
                    <Footer
                        style={{
                            textAlign: 'center',
                        }}
                    >
                        Alice RetroGame DB ©2023 Created by liuxp.me
                    </Footer>
                </Layout>

            </Layout>
        </Layout>
    );
};
export default controlPanel;
