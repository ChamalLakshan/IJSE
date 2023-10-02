import { Outlet } from "react-router-dom"

const Layout = () => {


    const handleShoppingCart = () => {

        localStorage.setBookinfo("cart",cart);

        localStorage.getBookinfo('cart');
    }

    return (
        <>
            <div className="navbar">Navigation</div>
                <Outlet />
                {}
            <footer>This is footer</footer>
        </>
    )
}

export default Layout;