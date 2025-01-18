Here is the entire `CONTRIBUTIONS.md` content in a fully copyable markdown format:
# Contributions to BankEase

Thank you for considering contributing to **BankEase**! We welcome all contributions, whether it's fixing bugs, adding new features, or improving the documentation. This outlines how you can contribute to this project.

## How to Contribute

### 1. Reporting Bugs
If you find a bug, please report it by opening an issue on the [GitHub Issues Page](https://github.com/Tarkan-Zarrouk/CPT/issues). Be sure to include:
- A clear description of the problem.
- Steps to reproduce the bug.
- Any relevant error messages or logs.

### 2. Suggesting Features
Have an idea to improve the app? Feel free to open an issue for feature suggestions. Please provide:
- A clear and detailed explanation of your suggestion.
- Any examples or use cases where the feature would be useful.

### 3. Submitting Code
We are happy to accept pull requests (PRs)! Please follow these steps to submit code:

#### Fork the Repository
1. Visit the [BankEase GitHub repository](https://github.com/Tarkan-Zarrouk/CPT).
2. Click on the "Fork" button to create a copy of the repository under your GitHub account.

#### Create a New Branch
1. In your forked repository, create a new branch for your changes. For example:  
   ```bash
   git checkout -b feature-new-feature
   ```

#### Make Your Changes
1. Add your changes in the appropriate files.
2. Make sure to write unit tests for new features or bug fixes.
3. Run all tests to ensure everything works correctly.

#### Commit Your Changes
1. Commit your changes with a meaningful message. Follow the [Conventional GitHub Commit Standards](https://www.conventionalcommits.org/en/v1.0.0/) for naming your commits.
   ```
   git commit -m "feat: Add new feature"
   ```

#### Push Your Changes
1. Push the branch to your forked repository.
   ```b
   git push origin feature-new-feature
   ```

#### Open a Pull Request (PR)
1. Navigate to the original repository and click the "Pull Requests" tab.
2. Click on the "New Pull Request" button.
3. Select the branch you created from your fork and compare it with the base branch of the original repository.
4. Provide a description of your changes and submit the pull request.

### 4. Code Review Process
Once your PR is submitted, it will be reviewed by myself. I may suggest changes or improvements. Please be responsive, any unactive PRs will be closed.

### 5. Merging PR
Once your PR has been approved, it will be merged into the main repository. You will be credited for your contribution in the project’s release notes.

## Coding Standards
- **Commit Naming**: Follow the [convetional commit standards](https://www.conventionalcommits.org/en/v1.0.0/) for every commit you make.
- **Method and Variable Naming**: Use descriptive names in camelCase.
- **Javadocs**: Update the javadocs folder with your feature by rerunning the command:```javadoc -d docs -sourcepath main -subpackages utils;```
- **Class Naming**: Use PascalCase for class names.
- **Unit Tests**: Write 1-3 unit tests per method you implement such that it is not a void method (if it is, then no need!)

## Documentation

If you're contributing to the documentation, here are a few guidelines:
- Follow the existing style of documentation.
- Make sure your additions are clear and concise.
- Provide examples when possible.

## Thank You!
I truly appreciate your contributions to **BankEase**. Your help will make this project even better and more useful for everyone. 😊

---

Feel free to contact me for any questions or further clarification.

- [GitHub Issues Page](https://github.com/Tarkan-Zarrouk/CPT/issues)

Note: If the requirements are failed to meet standards and no updated commits were made to fix this, it will be closed. You may reopen one till you implemented all the new changes request.