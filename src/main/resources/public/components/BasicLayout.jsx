const {  Layout, Menu, Breadcrumb ,theme ,Typography,Image} = antd;
const { Header, Content, Footer } = Layout;
const { Title } = Typography;

import SideMenu from "components/menu/index";

const BasicLayout = () => {

    const {
        token: { colorBgContainer },
    } = theme.useToken();

    return (
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
                    <Breadcrumb style={{ margin: '16px 0' }}>
                        <Breadcrumb.Item>Home</Breadcrumb.Item>
                        <Breadcrumb.Item>List</Breadcrumb.Item>
                        <Breadcrumb.Item>App</Breadcrumb.Item>
                    </Breadcrumb>
                    <Content
                        style={{
                            padding: 24,
                            margin: 0,
                            minHeight: 280,
                            background: colorBgContainer,
                        }}
                    >
                        Bill is a cat.
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
export default BasicLayout;