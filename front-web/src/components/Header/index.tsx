import React from 'react';
import { ReactComponent as Logo} from '../../assets/logo.svg'
import './style.css';

const Header = () => (
    <header className="main-header">
        <Logo/>
        <span className="logo-text-1">Big Game</span>
        <span className="logo-text-2"> Survey</span>
    </header>
);

export default Header;
