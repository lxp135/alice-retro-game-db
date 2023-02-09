const {  Layout, Menu, Breadcrumb ,theme ,Typography,Image} = antd;
const { Header, Content, Footer } = Layout;
const { Title } = Typography;

const InfraMenu = () => {

    const {
        token: { colorBgContainer },
    } = theme.useToken();

    console.log(ReactRouterDOM)

    return (
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
                Menu组件
            </Content>
        </Layout>
    );
};
export default InfraMenu;