import { makeStyles } from '@material-ui/styles';

export const useStyles = makeStyles(theme => ({
    root: {
      padding: theme.spacing(4)
    },
    content: {
      paddingTop: 100,
      textAlign: 'center'
    },
    image: {
      marginTop: 50,
      display: 'inline-block',
      maxWidth: '100%',
      width: 560
    }
  }));