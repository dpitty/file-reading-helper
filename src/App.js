import React, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";
import brace from "brace";
import { monokai } from "brace/theme/monokai";
import { github } from "brace/theme/github";
import "brace/mode/java";
import AceEditor from "react-ace";
import { tryCatchFinally, tooltips } from "./FileReaderExamples";
import beautify from "js-beautify";
class App extends Component {
  state = {
    codeShown: false
  };

  toggle = () => {
    const { codeShown } = this.state;
    this.setState({ codeShown: !codeShown });
    console.log("things have been clicked!");
  };

  handleOnChange = newVal => {
    console.log(newVal);
  };

  render() {
    const codeData = beautify(tryCatchFinally, { indent_size: 2 });
    console.log(codeData);
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          <code>src/App.js</code> and save to reload.
        </p>
        <button onClick={this.toggle}>Show Code</button>
        {this.state.codeShown && (
          <AceEditor
            mode="java"
            theme="monokai"
            onChange={this.handleOnChange}
            name="UNIQUE_ID_OF_DIV"
            defaultValue={codeData}
          />
        )}
      </div>
    );
  }
}

export default App;
