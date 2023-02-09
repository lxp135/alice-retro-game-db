const {  Layout, Menu, Breadcrumb ,theme } = antd;
const { SubMenu } = Menu;
const { Header, Content, Sider,Footer } = Layout;
const {BrowserRouter,Routes,Route,Link} = ReactRouterDOM;

const SideMenu = () => {

    const {
        token: { colorBgContainer },
    } = theme.useToken();

    let menuClick = (e) =>{
        //注意this指向问题，采用箭头函数this就指向当前组件
        // alert(1);
        // console.log(key);
        // if(key.key === '5'){
        //
        //     window.location.href = "/about"
        // }
        // window.location.href = "#key"+key.key

        // console.log(HistoryLibrary);
        // HistoryLibrary.createBrowserHistory().push(key.key)

        // this.props.history.push(key.path);

        // this.props.to(e.key);
    }



    const menuItems = [
        {
            key: '/about',
            icon:React.createElement(icons['UserOutlined']),
            label: <Link to="/about">成员管理</Link>,
        },
        {
            key: '/menu',
            icon:React.createElement(icons['UserOutlined']),
            label: <Link to="/menu">菜单管理</Link>,
        },
        {
            key: '/role',
            icon:React.createElement(icons['UserOutlined']),
            label: <Link to="/role">角色管理</Link>,
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
                // onClick={(e) =>{this.props.to(e.key);}}
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
