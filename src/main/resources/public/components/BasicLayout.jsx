const {  Layout, Menu, Breadcrumb ,theme ,Typography,Image} = antd;
const { Header, Content, Footer } = Layout;
const { Title } = Typography;

import SideMenu from "components/menu/index";
import InfraMenu from "pages/infra/menu/menu";
import InfraRole from "pages/infra/role/role";
const {BrowserRouter,Routes,Route,Link} = ReactRouterDOM;

const Home = () => {
    return <div><ul><li><Link to="/"> 首页</Link></li><li><Link to="/about">
                关于
            </Link>
        </li>
        <li>
            <Link to="/dashboard">
                仪表盘
            </Link>
        </li>
    </ul><div>hello world</div></div>
}

const BasicLayout = () => {

    const {
        token: { colorBgContainer },
    } = theme.useToken();

    console.log(ReactRouterDOM)

    return (
        <BrowserRouter>
        <Layout>
            <Header className="header">
                <div className="logo" >
                    <Image src="assets/image/logo.png" visible={false} style={{
                        marginLeft:-40,
                        marginTop:-4,
                    }}/>
                    {/*<span style={{color:'white',fontWeight:'bold'}}>Alice RetroGame DB</span>*/}
                </div>
            </Header>
            <Layout>
                <SideMenu/>
                <Layout style={{ padding: '0 24px 24px' }}>
                    <Routes>
                        <Route path="/" element={<Home />} />
                        <Route path="/menu" element={<InfraMenu />} />
                        <Route path="/role" element={<InfraRole />} />
                    </Routes>
                    <Footer
                        style={{
                            textAlign: 'center',
                        }}
                    >
                        Alice RetroGame DB ©2023 Created by <a href={'https://liuxp.me'} target={'_blank'}>liuxp.me</a>
                    </Footer>
                </Layout>
            </Layout>
        </Layout>
        </BrowserRouter>
    );
};
export default BasicLayout;