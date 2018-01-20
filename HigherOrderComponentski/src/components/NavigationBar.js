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
    this.handleDrawerToggle = this.handleDrawerToggle.bind(this);
    this.authenticateUser = this.authenticateUser.bind(this);
    this.logoutUser = this.logoutUser.bind(this);
  }

  handleDrawerToggle(){
    this.setState({open: !this.state.open});
  }

  handleNavigation(route){
    browserHistory.push(route);
    this.handleDrawerToggle();
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
          onLeftIconButtonClick={this.handleDrawerToggle}
        />
        <Drawer
          docked={false}
          width={250}
          open={this.state.open}
          onRequestChange={(open) => this.setState({ open })}
        >
          <MenuItem
            primaryText="Default"
            onClick={()=> this.handleNavigation('/')}
          />
          <MenuItem
            primaryText="Main Base Encampment"
            onClick={()=> this.handleNavigation('/homeBase')}
          />
          <MenuItem
            primaryText="Vault"
            onClick={()=> this.handleNavigation('/treasureVault')}
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