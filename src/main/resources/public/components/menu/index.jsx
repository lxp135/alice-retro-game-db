const {  Layout, Menu, Breadcrumb ,theme } = antd;
const { SubMenu } = Menu;
const { Header, Content, Sider,Footer } = Layout;

const SideMenu = () => {

    const {
        token: { colorBgContainer },
    } = theme.useToken();

    let menuClick = function(key){
        // alert(1);
        console.log(key);
        window.location.href = "#key"+key.key
    }

    const menuItems = [
        {
            key: 'center',
            icon:React.createElement(icons['UserOutlined']),
            label: '个人中心',
        },
        {
            key: 'settings',
            icon:React.createElement(icons['SettingOutlined']),
            label: '个人设置',
            children: new Array(4).fill(null).map((_, j) => {
                const subKey =  4 + j + 1;
                return {
                    key: subKey,
                    label: `option${subKey}`,
                };
            }),
        },
        {
            key: 'logout',
            icon:React.createElement(icons['LogoutOutlined']),
            label: '退出登录',
        },
    ];

    return (
        <Sider
            width={200}
            style={{ background: colorBgContainer }}
        >
            <Menu
                onClick={menuClick}
                mode="inline"
                defaultSelectedKeys={['1']}
                defaultOpenKeys={['sub1']}
                style={{
                    height: '100%',
                    borderRight: 0,
                }}
                items={menuItems}
            >
            </Menu>
        </Sider>
    );
};
export default SideMenu;
