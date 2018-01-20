import React, {Component} from 'react';
import AppBar from 'material-ui/AppBar';
import Drawer from 'material-ui/Drawer';
import MenuItem from 'material-ui/MenuItem';
import Divider from 'material-ui/Divider';
import { browserHistory } from 'react-router';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import login from '../actions/login';
import logout from '../actions/logout';

class NavigationBar extends Component{

  constructor(props) {
    super(props);
    this.state = {
      open: false
    };
    this.handleToggle = this.handleToggle.bind(this);
    this.handleDefaultRoute = this.handleDefaultRoute.bind(this);
    this.handleHomeBaseRoute = this.handleHomeBaseRoute.bind(this);
    this.handleVaultRoute = this.handleVaultRoute.bind(this);
    this.authenticateUser = this.authenticateUser.bind(this);
    this.logoutUser = this.logoutUser.bind(this);
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

  authenticateUser(){
    this.props.login();
  }

  logoutUser(){
    this.props.logout();
  }

  render(){
    console.log('jeffskis props', this.props);
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
        <Divider />
          <MenuItem
            primaryText={this.props.isGuildMember ? "Sign Out" : "Sign In"}
            onClick={this.props.isGuildMember ? this.logoutUser : this.authenticateUser}
            >
          </MenuItem>
        </Drawer>
      </div>
    );
  }

}

function mapDispatchToProps(dispatch){
  return bindActionCreators({ login, logout }, dispatch);
}

function mapStateToProps(state){
  return{isGuildMember: state.authStatus}
}

export default connect(mapStateToProps, mapDispatchToProps)(NavigationBar);