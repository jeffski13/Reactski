import React, {Component} from 'react';
import AppBar from 'material-ui/AppBar';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';
import { browserHistory } from 'react-router';

class NavigationBar extends Component{

  constructor(props) {
    super(props);
    this.state = {
      open: false,
      signedIn: false
    };
    this.handleToggle = this.handleToggle.bind(this);
    this.handleDefaultRoute = this.handleDefaultRoute.bind(this);
    this.handleHomeBaseRoute = this.handleHomeBaseRoute.bind(this);
    this.handleVaultRoute = this.handleVaultRoute.bind(this);
  }

  handleToggle(){
    this.setState({open: !this.state.open});
  }

  handleDefaultRoute(){
    this.handleNavigation('/')
  }

  handleHomeBaseRoute(){
    this.handleNavigation('/homeBase')
  }

  handleVaultRoute(){
    this.handleNavigation('/treasureVault')
  }

  handleNavigation(route){
    browserHistory.push(route);
    this.handleToggle();
  }

  render(){
    return(
      <div>
        <AppBar
          title="High Componentskis"
          onLeftIconButtonClick={this.handleToggle }
        />
        <Drawer
          docked={false}
          width={200}
          open={this.state.open}
          onRequestChange={(open) => this.setState({ open })}
        >
          <MenuItem
            primaryText="Default"
            onClick={this.handleDefaultRoute}
          />
          <MenuItem
            primaryText="Main Base Encampment"
            onClick={this.handleHomeBaseRoute}
          />
          <MenuItem
            primaryText="Vault"
            onClick={this.handleVaultRoute}
          />
          <MenuItem
            primaryText={this.state.signedIn ? "Sign Out" : "Sign In"}
            >
          </MenuItem>
        </Drawer>
      </div>
    );
  }

}

export default NavigationBar;